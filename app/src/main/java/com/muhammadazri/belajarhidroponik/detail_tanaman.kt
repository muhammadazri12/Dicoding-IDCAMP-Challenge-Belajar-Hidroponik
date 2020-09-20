package com.muhammadazri.belajarhidroponik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class detail_tanaman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tanaman)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Tanaman"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName : TextView =findViewById(R.id.tv_item_tanaman_name)
        val imgSetPhoto : ImageView = findViewById(R.id.img_item_photo_tanaman)
        val tvSetGizi : TextView = findViewById(R.id.tv_set_gizi)
        val tvSetPanen : TextView = findViewById(R.id.tv_set_masaPanen)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val tGizi = intent.getStringExtra(EXTRA_GIZI)
        val tPanen = intent.getStringExtra(EXTRA_PANEN)

        tvSetName.text =tName
        Glide.with(this)
            .load(tPhoto)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetGizi.text = tGizi
        tvSetPanen.text = tPanen
    }
    companion object{
        const val EXTRA_NAME ="extra_name"
        const val EXTRA_PHOTO ="extra_photo"
        const val EXTRA_GIZI ="extra_gizi"
        const val EXTRA_PANEN ="extra_panen"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.miCompose ->{
                val iAbout = Intent(this@detail_tanaman, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}