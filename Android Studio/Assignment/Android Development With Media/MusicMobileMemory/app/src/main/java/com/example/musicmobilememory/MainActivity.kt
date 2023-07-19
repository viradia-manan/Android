package com.example.musicmobilememory

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var songListView: ListView
    private lateinit var mediaPlayer: MediaPlayer
    private var songList: ArrayList<String> = ArrayList()

    private val PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songListView = findViewById(R.id.songListView)
        mediaPlayer = MediaPlayer()

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
            )
        } else {
            loadSongList()
        }

        songListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                // Play the selected song
                val songUri = getSongUri(position)
                if (songUri != null) {
                    mediaPlayer.apply {
                        reset()
                        setDataSource(songUri)
                        prepare()
                        start()
                    }
                }
            }
    }

    private fun loadSongList() {
        val projection = arrayOf(MediaStore.Audio.Media.TITLE)
        val cursor = contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            MediaStore.Audio.Media.TITLE
        )

        cursor?.use {
            val titleColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            while (it.moveToNext()) {
                val title = it.getString(titleColumn)
                songList.add(title)
            }
        }

        cursor?.close()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songList)
        songListView.adapter = adapter
    }

    private fun getSongUri(position: Int): String? {
        val projection = arrayOf(MediaStore.Audio.Media.DATA)
        val selection = "${MediaStore.Audio.Media.TITLE} = ?"
        val selectionArgs = arrayOf(songList[position])

        val cursor = contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            null
        )

        cursor?.use {
            val dataColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            if (it.moveToFirst()) {
                return it.getString(dataColumn)
            }
        }

        cursor?.close()

        return null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadSongList()
            } else {
                // Permission denied, handle accordingly
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
