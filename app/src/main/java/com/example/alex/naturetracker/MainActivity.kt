package com.example.alex.naturetracker
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_map.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //you know the deal
        var loginButton = findViewById<Button>(R.id.loginbtn)

        // Initialize Firebase Auth
        var auth = FirebaseAuth.getInstance()

        //signup nav
        var signupnav = findViewById<TextView>(R.id.signupnav)

        //If user is currently logged in
        val currentUser = auth.currentUser

        //Changing the ui based on user logged in bool
        fun updateUI()
        {
            val intent = Intent(this, option::class.java)
            startActivity(intent)
        }

        //progessing to next screen
        if (currentUser != null) {
            updateUI()
        }


        // sign up button functionality
        signupnav.setOnClickListener()
        {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

        var forgottenpassword = findViewById<TextView>(R.id.forgottenpassword)

        forgottenpassword.setOnClickListener()
        {
            val intent = Intent(this, com.example.alex.naturetracker.forgottenpassword::class.java)
            startActivity(intent)
        }


        //Logic for logging in
        loginButton.setOnClickListener {


            var email = findViewById<EditText>(R.id.inputlogin).text.toString()
            var password = findViewById<EditText>(R.id.inputpassword).text.toString()

            if (email.length > 5)
            {
                if ( password.length > 1)
                {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = auth.currentUser
                                updateUI()
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
            else
            {
                Toast.makeText(baseContext, "something isn't right ",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



        }








    }
}
