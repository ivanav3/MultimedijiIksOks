package com.example.multimedijiiksoks

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class ZavrsnaAktivnost : AppCompatActivity(){

    var mp: MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zavrsna_aktivnost)

        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.kraj)
            mp!!.isLooping=false
            mp!!.start()
        }

        var intent1: Intent
        intent1 = getIntent()
        var brojPobedaX: Int = intent1.getIntExtra("pobedeX", 0)
        var brojPobedaO: Int = intent1.getIntExtra("pobedeO", 0)

        var tekstPobeda: TextView = findViewById(R.id.tekstPobeda)

        if (brojPobedaX == brojPobedaO) {
            tekstPobeda.text = "Nerešeno!"
        } else if (brojPobedaX > brojPobedaO) {
            tekstPobeda.text = "Pobednik je X!"
        } else if (brojPobedaX < brojPobedaO) {
            tekstPobeda.text = "Pobednik je O!"
        } else {
            tekstPobeda.text = "Greska!"
        }


        var dugmeKraj = findViewById<Button>(R.id.buKraj)
        dugmeKraj.setOnClickListener {
            var izlaz = Intent(this, UvodnaAktivnost::class.java)
            startActivity(izlaz)
        }
    }
}
