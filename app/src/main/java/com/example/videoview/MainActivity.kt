package com.example.videoview

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var videoView: VideoView? = null
    private var mediaController: MediaController? = null
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onResume()

        videoView = findViewById<View>(R.id.vd) as VideoView?
        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        videoView!!.requestFocus()
        videoView!!.start()



        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Mana bo'ldi", Toast.LENGTH_LONG).show()
            false
        }


    }
}