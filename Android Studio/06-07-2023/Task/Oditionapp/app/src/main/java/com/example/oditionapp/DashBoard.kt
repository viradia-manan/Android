package com.example.oditionapp

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.oditionapp.databinding.ActivityDashBoardBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.core.view.View
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class DashBoard : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardBinding
    lateinit var sharedPreferences: SharedPreferences
    val VIDEO: Int = 3
    lateinit var uri: Uri
    lateinit var mStorage: StorageReference

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)

        mStorage = FirebaseStorage.getInstance().getReference("video_upload")

        sharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE)

        binding.logout.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            finish()
            var i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)

        }


        binding.videoBtn.setOnClickListener {
            val intent = Intent()
            intent.setType ("video/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Video"), VIDEO)
        }
    }
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == VIDEO) {
                uri = data!!.data!!
                binding.uriTxt.text = uri.toString()
                upload ()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun upload() {
        var mReference = mStorage.child(uri.lastPathSegment.toString())
        try {
            mReference.putFile(uri).addOnSuccessListener {
                    taskSnapshot: UploadTask.TaskSnapshot? -> var url = taskSnapshot
                binding.dwnTxt.text = url.toString()
                Toast.makeText(this, "Successfully Uploaded", Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
