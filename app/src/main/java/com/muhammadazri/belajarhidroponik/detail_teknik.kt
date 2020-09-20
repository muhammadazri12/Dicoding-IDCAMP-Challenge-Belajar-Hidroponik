package com.muhammadazri.belajarhidroponik

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class detail_teknik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_teknik)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Teknik"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName :TextView = findViewById(R.id.tv_item_teknik_name)
        val imgSetPhoto :ImageView = findViewById(R.id.img_item_photo_teknik)
        val tvSetPengertian :TextView = findViewById(R.id.tv_set_pengertian)
        val tvSetBahan: TextView = findViewById(R.id.tv_set_bahan)
        val tvSetCara: TextView =findViewById(R.id.tv_set_cara)
        val tvSetKelebihan : TextView = findViewById(R.id.tv_set_kelebihan)
        val tvSetKekurangan: TextView = findViewById(R.id.tv_set_kekurangan)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tPeng = intent.getStringExtra(EXTRA_PENGERTIAN)
        val tBah = intent.getStringExtra(EXTRA_BAHAN)
        val tCar = intent.getStringExtra(EXTRA_CARA)
        val tLeb = intent.getStringExtra(EXTRA_KELEBIHAN)
        val tKer = intent.getStringExtra(EXTRA_KEKURANGAN)

        tvSetName.text =tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetPengertian.text = tPeng
        tvSetBahan.text = tBah
        tvSetCara.text = tCar
        tvSetKelebihan.text = tLeb
        tvSetKekurangan.text = tKer
    }
    companion object{
        const val EXTRA_NAME ="extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PENGERTIAN = "extra_pengertian"
        const val EXTRA_BAHAN = "extra_bahan"
        const val EXTRA_CARA = "extra_cara"
        const val EXTRA_KELEBIHAN ="extra_kelebihan"
        const val EXTRA_KEKURANGAN ="extra_kekurangan"
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
                val iAbout = Intent(this@detail_teknik, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}