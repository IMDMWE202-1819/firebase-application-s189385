package com.example.alex.naturetracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth



class forgottenpassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgottenpassword)


        fun emailsub()
        {
            var email = findViewById<EditText>(R.id.forgotemail).text.toString()

            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // confirming email has been sent
                        Toast.makeText(baseContext, "Email sent!.",
                            Toast.LENGTH_SHORT).show()
                    }else
                    {
                        Toast.makeText(baseContext, "check the email and try again.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        var forgotbtn = findViewById<Button>(R.id.forgotbutton)

        forgotbtn.setOnClickListener(){
            emailsub()
        }



    }
}
