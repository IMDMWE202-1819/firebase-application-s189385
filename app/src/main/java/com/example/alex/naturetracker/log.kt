package com.example.alex.naturetracker

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint

class log : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)



        var logbutton = findViewById<Button>(R.id.logitem)


        logbutton.setOnClickListener()
        {
            var itemdescription = findViewById<EditText>(R.id.descriptiontext)

            if (itemdescription.text.toString() == null)
            {
                Toast.makeText(baseContext, "please input description",
                    Toast.LENGTH_SHORT).show()
            }
            else
            {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

                //asks user permission
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                {
                    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
                    ActivityCompat.requestPermissions(this, permissions,0)

                }
                //if user has given permission
                else
                {

                    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? -> var geo = GeoPoint(location!!.latitude, location.longitude)


                        var currentpin : pin = pin()

                        currentpin.location = geo
                        currentpin.description = itemdescription.text.toString()

                        val data = HashMap<String, Any>()
                        data["location"] = currentpin.location.toString()
                        data["description"] = currentpin.description

                        var db = FirebaseFirestore.getInstance()

                        db.collection("mycollection").add(data)

                        Toast.makeText(baseContext, "item logged",
                            Toast.LENGTH_SHORT).show()

                    }
            }
        }


        }













    }
}