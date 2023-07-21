package com.example.userandadmin

import android.content.Context
import android.media.Image
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.Locale

class Myadapter(var context: Context, var list:MutableList<Model>):BaseAdapter(),
    TextToSpeech.OnInitListener {
    lateinit var tts: TextToSpeech

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @Suppress("DEPRECATION")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        tts = TextToSpeech(context,this)

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,p2,false)

        var image:ImageView = view.findViewById(R.id.img)
        var mice:TextView = view.findViewById(R.id.mic)

        Picasso.get().load(list.get(p0).img)
            .placeholder(R.mipmap.ic_launcher).resize(100,100)
            .centerCrop()
            .into(image)


        mice.setOnClickListener {
            var name =  mice.setText(list.get(p0).name)

            tts.speak(name.toString(),TextToSpeech.QUEUE_ADD,null)
        }
        return view
    }

    override fun onInit(p0: Int)
    {
        tts.setLanguage(Locale.US)
        tts.setPitch(0.8F)
        tts.setSpeechRate(0.5F)

    }

}