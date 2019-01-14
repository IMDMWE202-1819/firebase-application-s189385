package com.example.alex.naturetracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint

class Map: AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {






        mMap = googleMap


        // Add a marker in Sydney and move the camera





        var db = FirebaseFirestore.getInstance()
        var mylist : ArrayList<pin> = ArrayList()


        //gets database documents under my collection
        db.collection("mycollection")
            .get()
            .addOnSuccessListener { documents ->
                //for each item it creates the marker and adds description
                for (document in documents) {

                    var mystring = document["location"].toString()


                    var list = mystring.split(",")

                    val re = Regex("[Pg}Geopint{ laud=]")

                    var lat =  re.replace(list[0].toString(), "")
                    var lon = re.replace(list[1].toString(), "")

                    var currentgeo : GeoPoint = GeoPoint(lat.toDouble() , lon.toDouble())

                    var currentdes = document["description"].toString()

                    var newpin = pin()

                    newpin.location = currentgeo
                    newpin.description = currentdes


                    val currentmarker = LatLng(currentgeo.latitude, currentgeo.longitude)

                    mMap.addMarker(MarkerOptions().position(currentmarker).title(currentdes))
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentmarker))
                }
            }
            .addOnFailureListener {
            }


      


    }


    }

