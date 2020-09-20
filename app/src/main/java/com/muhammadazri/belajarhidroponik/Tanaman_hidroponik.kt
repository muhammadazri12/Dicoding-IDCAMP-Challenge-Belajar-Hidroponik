package com.muhammadazri.belajarhidroponik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tanaman_hidroponik : AppCompatActivity() {
    private lateinit var rvTanaman: RecyclerView
    private var list: ArrayList<Tanaman> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanaman_hidroponik)
        val actionbar = supportActionBar
        actionbar!!.title="Tanaman"
        actionbar.setDisplayHomeAsUpEnabled(true)

        rvTanaman = findViewById(R.id.rv_tanaman)
        rvTanaman.setHasFixedSize(true)

        list.addAll(TanamanData.listData)
        showRecylerList()
    }

    private fun showRecylerList(){
        rvTanaman.layoutManager = LinearLayoutManager(this)
        val listTanamanAdapter = ListTanamanAdapter(list)
        rvTanaman.adapter =listTanamanAdapter
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
                val iAbout = Intent(this@Tanaman_hidroponik, about::class.java)
                startActivity(iAbout)
            }
        }
    }

}