package com.example.multimedijiiksoks

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class UvodnaAktivnost : AppCompatActivity() {

    var mp:MediaPlayer?=null
   lateinit var cl: ConstraintLayout
    var ad: AnimationDrawable?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uvodna_aktivnost)

        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.pocetak)
            mp!!.isLooping=false
            mp!!.start()
        }
        cl=findViewById(R.id.animacijaLayout)


        ad = cl.getBackground () as AnimationDrawable?
        ad?.setEnterFadeDuration(2500)
        ad?.setExitFadeDuration(5000)
        ad?.start()

        val dugmePocetak = findViewById<Button>(R.id.buZapocni)
        dugmePocetak.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            var ispocetka=1
            intent.putExtra("ispocetka",ispocetka)

            startActivity(intent)
        }

    }
}