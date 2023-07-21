package com.example.userandadmin

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.wear.tiles.material.Text
import com.example.userandadmin.databinding.ActivityAdminBinding
import net.gotev.uploadservice.MultipartUploadRequest

class AdminActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdminBinding
    lateinit var filepath: Uri
    lateinit var  bitmap: Bitmap
    var data = arrayOf("Choose Category","Animal","Bird")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //permission
        requestpermission()

        var adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,data)
        binding.spinner.adapter=adapter

        binding.btnimg.setOnClickListener {
            var i = Intent()
            i.type = "image/*"
            i.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)
        }

        binding.btnadd.setOnClickListener {
            val name = binding.edtname.text.toString()
            var category = binding.spinner.selectedItem
            val path = getPath(filepath)
            MultipartUploadRequest(this,"https://mananviradia14.000webhostapp.com/A_U/insert.php")
                .addFileToUpload(path, "url")
                .addParameter("name", name)
                .addParameter("category", category.toString())
                .setMaxRetries(3)
                .startUpload()
            Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
        }

    }

    private fun requestpermission()
    {
        if(checkSelfPermission(READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE),100)
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1 && resultCode == RESULT_OK && data != null)
        {

            filepath = data.data!!
            bitmap= MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            binding.img.setImageBitmap(bitmap)

        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}