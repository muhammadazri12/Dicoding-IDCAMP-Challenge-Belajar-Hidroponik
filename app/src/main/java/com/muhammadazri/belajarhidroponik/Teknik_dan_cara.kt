package com.muhammadazri.belajarhidroponik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Teknik_dan_cara : AppCompatActivity() {
    private lateinit var rvTeknik: RecyclerView
    private var list: ArrayList<Teknik> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_dan_cara)
        val actionbar = supportActionBar
        actionbar!!.title="Teknik"
        actionbar.setDisplayHomeAsUpEnabled(true)

        rvTeknik = findViewById(R.id.rv_teknik)
        rvTeknik.setHasFixedSize(true)

        list.addAll(TeknikData.listData)
        showRecylerList()
    }

    private fun showRecylerList(){
        rvTeknik.layoutManager = LinearLayoutManager(this)
        val listTeknikAdapter = ListTeknikAdapter(list)
        rvTeknik.adapter =listTeknikAdapter
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
                val iAbout = Intent(this@Teknik_dan_cara, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}