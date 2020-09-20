package com.muhammadazri.belajarhidroponik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        val btnApaItu: Button = findViewById(R.id.btn_apa_itu_hidroponik)
        btnApaItu.setOnClickListener(this)
        val btnTeknik: Button = findViewById(R.id.btn_teknik_dan_cara)
        btnTeknik.setOnClickListener(this)
        val btnTanaman: Button = findViewById(R.id.btn_tanaman)
        btnTanaman.setOnClickListener(this)
        val btnTabel: Button = findViewById(R.id.btn_tabel_ppmDanPH)
        btnTabel.setOnClickListener(this)

    }
    override fun onClick (v: View){
        when(v.id){
            R.id.btn_apa_itu_hidroponik->{
                val moveIntent = Intent(this@MainActivity, ApaItuHidroponik::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_teknik_dan_cara->{
                val moveIntent = Intent(this@MainActivity, Teknik_dan_cara::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_tanaman->{
                val moveIntent = Intent(this@MainActivity, Tanaman_hidroponik::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_tabel_ppmDanPH->{
                val moveIntent = Intent(this@MainActivity, Tabel_PPM_dan_PH::class.java)
                startActivity(moveIntent)
            }
        }
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
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}