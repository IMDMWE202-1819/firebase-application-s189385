package com.example.alex.naturetracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_map.*

class option : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        var log = findViewById<TextView>(R.id.logbutton)
        var look = findViewById<TextView>(R.id.lookbutton)

        fun Navigate( kotlin: SinceKotlin)
        {
             var intent =Intent(this, kotlin::class.java)
            startActivity(intent)
        }

        look.setOnClickListener(){
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }

        log.setOnClickListener()
        {
            val intent = Intent(this, com.example.alex.naturetracker.log::class.java)
            startActivity(intent)
        }






    }
}
