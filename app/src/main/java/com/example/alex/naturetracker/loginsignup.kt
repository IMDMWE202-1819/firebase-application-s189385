package com.example.alex.naturetracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.R.attr.fragment
import android.widget.Button
import kotlinx.android.synthetic.main.activity_loginsignup.*
import android.R.attr.fragment
import com.example.alex.naturetracker.R.id.add


class loginsignup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginsignup)

        val loginbutton = findViewById<Button>(R.id.login)
        val signup = findViewById<Button>(R.id.signup)
        val nologin = findViewById<Button>(R.id.nologin)
        val manager = supportFragmentManager

        loginbutton.setOnClickListener {

            val myfragment = loginfragment()

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.fragment, myfragment)
            transaction.addToBackStack(null)

            // Finishing the transition
            transaction.commit()
        }


    }


}
