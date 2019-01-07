package com.example.alex.naturetracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //progressing based on user function
        fun updateUI()
        {
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }

        //for navigation button
        val signupbutton = findViewById<Button>(R.id.signupbutton)

        //on click logic
        signupbutton.setOnClickListener {

             val auth = FirebaseAuth.getInstance()

            //taking in strings
            var email = findViewById<EditText>(R.id.inputsignup).text.toString()
            var password = findViewById<EditText>(R.id.inputpasswordsignup).text.toString()
            var password1 = findViewById<EditText>(R.id.inputpasswordsignup1).text.toString()


            //logic making sure there are texts in fields
                if (email.length > 6)
                {
                    if (password.length > 1)
                    {
                        if(password == password1) {
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this) { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(
                                            baseContext, "Authentication success.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(
                                            baseContext, "Authentication failed.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                }
                        }
                        else
                        {
                            Toast.makeText(baseContext, "passwords don't match",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                } else
            {
                Toast.makeText(baseContext, "something isn' right",
                    Toast.LENGTH_SHORT).show()
            }
            }




        }



    }




