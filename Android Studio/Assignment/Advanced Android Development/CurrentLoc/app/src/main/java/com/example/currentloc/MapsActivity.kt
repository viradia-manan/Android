package com.example.currentloc

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.currentloc.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback
{

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var locationManager: LocationManager
    lateinit var locationListener: LocationListener
    var lattitude:Double = 0.00
    var longitude:Double = 0.00
    lateinit var location:Location

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(applicationContext,ACCESS_FINE_LOCATION)!= PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext,ACCESS_COARSE_LOCATION)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(ACCESS_FINE_LOCATION),101)
            requestPermissions(arrayOf(ACCESS_COARSE_LOCATION),102)
        }

        if (!locationManager.isProviderEnabled(NETWORK_PROVIDER))
        {
            Toast.makeText(applicationContext,"Internet is not working",Toast.LENGTH_LONG).show()
        }
        if (!locationManager.isProviderEnabled(GPS_PROVIDER))
        {
            Toast.makeText(applicationContext,"GPS is not working",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Fetching Location",Toast.LENGTH_LONG).show()
        }

        locationListener = object:LocationListener
        {
            override fun onLocationChanged(p0: Location)
            {
                lattitude = p0.getLatitude()
                longitude = p0.getLongitude()
            }
        }

        if (locationManager.isProviderEnabled(NETWORK_PROVIDER))
        {
            locationManager.requestLocationUpdates(NETWORK_PROVIDER,0,0.0F,locationListener)
        }

        location = locationManager.getLastKnownLocation(NETWORK_PROVIDER)!!

        if (location!=null)
        {
            lattitude = location.getLatitude()
            longitude = location.getLongitude()
            Toast.makeText(applicationContext,""+location.getLatitude(),Toast.LENGTH_LONG).show()
        }

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
        val sydney = LatLng(lattitude, longitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        if(requestCode==101 && requestCode==102)
        {
            Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Permission Error",Toast.LENGTH_LONG).show()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}