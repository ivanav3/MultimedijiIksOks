package com.example.multimedijiiksoks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class UvodnaAktivnost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uvodna_aktivnost)

        val dugmePocetak = findViewById<Button>(R.id.buZapocni)
        dugmePocetak.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            var ispocetka=1
            intent.putExtra("ispocetka",ispocetka)

            startActivity(intent)
        }

    }
}