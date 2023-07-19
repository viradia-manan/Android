package com.example.inputtypeaddress

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var googleMap: GoogleMap
    private lateinit var addressInput: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        addressInput = findViewById(R.id.addressInput)
        val showMarkerButton = findViewById<Button>(R.id.showMarkerButton)
        showMarkerButton.setOnClickListener {
            showMarkerOnMap()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
    }

    @Suppress("DEPRECATION")
    private fun showMarkerOnMap()
    {
        val address = addressInput.text.toString()

        if (address.isEmpty()) {
            Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show()
            return
        }

        val geocoder = Geocoder(this)
        val addresses: List<Address> = geocoder.getFromLocationName(address, 1)!!

        if (addresses.isNotEmpty()) {
            val location = LatLng(addresses[0].latitude, addresses[0].longitude)
            googleMap.clear() // Clear previous markers
            googleMap.addMarker(MarkerOptions().position(location).title(address))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        } else {
            Toast.makeText(this, "Address not found", Toast.LENGTH_SHORT).show()
        }
    }
}