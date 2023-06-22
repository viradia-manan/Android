package com.example.multipleimageupload

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import net.gotev.uploadservice.MultipartUploadRequest
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var button2: Button
    private lateinit var fileUris: MutableList<Uri>
    private lateinit var bitmaps: MutableList<Bitmap>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edt1)
        button = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        imageView = findViewById(R.id.img)

        fileUris = mutableListOf()
        bitmaps = mutableListOf()

        button.setOnClickListener(this)
        button2.setOnClickListener(this)

        requestpermission()
    }

    private fun requestpermission()
    {
        if(checkSelfPermission(READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE),100)
        }
        else
        {
            Toast.makeText(applicationContext,"Permission alread granted",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            button -> openImagePicker()
            button2 -> uploadImages()
        }
    }

    @Suppress("DEPRECATION")
    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(Intent.createChooser(intent, "Select Pictures"), 1)
    }

    private fun uploadImages() {
        val name = editText.text.toString()
        for (i in 0 until fileUris.size) {
            val path = getPath(fileUris[i])
            MultipartUploadRequest(
                this,
                "https://mananviradia14.000webhostapp.com/uploadimage/upload.php"
            )
                .addFileToUpload(path, "files")
                .addParameter("edtname", name)
                .setMaxRetries(2)
                .startUpload()
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val clipData = data.clipData
            if (clipData != null) {
                for (i in 0 until clipData.itemCount) {
                    val imageUri = clipData.getItemAt(i).uri
                    fileUris.add(imageUri)
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                    bitmaps.add(bitmap)
                }
            } else {
                val imageUri = data.data
                fileUris.add(imageUri!!)
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                bitmaps.add(bitmap)
            }

            // Set the bitmap of the first image to the imageView
            imageView.setImageBitmap(bitmaps[0])
        }
    }
}
