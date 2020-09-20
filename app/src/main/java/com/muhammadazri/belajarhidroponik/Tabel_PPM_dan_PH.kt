package com.muhammadazri.belajarhidroponik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Tabel_PPM_dan_PH : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabel__p_p_m_dan__p_h)
        val actionBar = supportActionBar
        actionBar!!.title = "Tabel PPM Dan PH"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}