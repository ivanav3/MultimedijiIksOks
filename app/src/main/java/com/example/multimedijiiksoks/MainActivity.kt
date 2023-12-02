package com.example.multimedijiiksoks

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var brojPobeda1=0  // 1 je X
    var brojPobeda2=0  // 2 je O

    var naPotezu=1

    var iks=ArrayList<Int>()
    var oks=ArrayList<Int>()

    var pobednik=-1

    var ispocetka=0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent: Intent = getIntent()
        brojPobeda1 = intent.getIntExtra("pobedeX", 0)
        brojPobeda2 = intent.getIntExtra("pobedeO", 0)
        var iksNiz=intent.getIntArrayExtra("iksNiz")
        var oksNiz=intent.getIntArrayExtra("oksNiz")
        naPotezu=intent.getIntExtra("potez",1)
        pobednik=intent.getIntExtra("pobednik",-1)

        ispocetka=intent.getIntExtra("ispocetka",0)


        val tekstId: TextView =findViewById(R.id.text_view_id)

        if(ispocetka==1){
            tekstId.text="Kliknite na polje koje želite da izaberete"

        }else{
            tekstId.text="Broj pobeda X: $brojPobeda1\n" + "Broj pobeda O: $brojPobeda2"
        }

        iks.clear()
        oks.clear()

        for(i in 1..9){
            if (iksNiz != null) {
                if(iksNiz.contains(i)){
                    iks.add(i)
                }
            }
            if(oksNiz!=null){
                if(oksNiz.contains(i)){
                    oks.add(i)
                }
            }
        }

        var dugme: Button =findViewById(R.id.bu1)

        if(iks!=null){
            if(iks.contains(1)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu2)
            if(iks.contains(2)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu3)
            if(iks.contains(3)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu4)
            if(iks.contains(4)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu5)
            if(iks.contains(5)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu6)
            if(iks.contains(6)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu7)
            if(iks.contains(7)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu8)
            if(iks.contains(8)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu9)
            if(iks.contains(9)){
                dugme.text="X"
                dugme.setBackgroundColor(Color.parseColor("#F48271"))
                dugme.isEnabled=false
            }
        }
        dugme=findViewById(R.id.bu1)

        if(oks!=null){
            if(oks.contains(1)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu2)
            if(oks.contains(2)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu3)
            if(oks.contains(3)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu4)
            if(oks.contains(4)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu5)
            if(oks.contains(5)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu6)
            if(oks.contains(6)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu7)
            if(oks.contains(7)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu8)
            if(oks.contains(8)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
            dugme=findViewById(R.id.bu9)
            if(oks.contains(9)){
                dugme.text="O"
                dugme.setBackgroundColor(Color.parseColor("#FFC84D"))
                dugme.isEnabled=false
            }
        }


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        var rotacija = Intent(this, MainActivity::class.java)
        rotacija.putExtra("pobedeX", brojPobeda1)
        rotacija.putExtra("pobedeO", brojPobeda2)
        rotacija.putExtra("iksNiz",iks.toIntArray())
        rotacija.putExtra("oksNiz",oks.toIntArray())
        rotacija.putExtra("potez",naPotezu)
        rotacija.putExtra("pobednik",pobednik)

        rotacija.putExtra("ispocetka",ispocetka)

        startActivity(rotacija)

    }

    fun buClick(view: View){
        val buIzabrano=view as Button
        var celijaID=0
        when(buIzabrano.id){
            R.id.bu1->celijaID=1
            R.id.bu2->celijaID=2
            R.id.bu3->celijaID=3
            R.id.bu4->celijaID=4
            R.id.bu5->celijaID=5
            R.id.bu6->celijaID=6
            R.id.bu7->celijaID=7
            R.id.bu8->celijaID=8
            R.id.bu9->celijaID=9
        }

        igra(celijaID,buIzabrano)

    }


    private fun igra(celijaID:Int, buIzabrano: Button) {
        if(pobednik==-1) {
            if (naPotezu == 1) {
                buIzabrano.text = "X"
                buIzabrano.setBackgroundColor(Color.parseColor("#F48271"))
                iks.add(celijaID)
                naPotezu = 2
            } else {
                buIzabrano.text = "O"
                buIzabrano.setBackgroundColor(Color.parseColor("#FFC84D"))
                oks.add(celijaID)
                naPotezu = 1
            }
        }

        buIzabrano.isEnabled = false
        pobeda()

    }



    private fun pobeda() {

        //1. red
        if(iks.contains(1)&&iks.contains(2)&&iks.contains(3)){
            pobednik=1
        }
        if(oks.contains(1)&&oks.contains(2)&&oks.contains(3)){
            pobednik=2
        }
        //2. red
        if(iks.contains(4)&&iks.contains(5)&&iks.contains(6)){
            pobednik=1
        }
        if(oks.contains(4)&&oks.contains(5)&&oks.contains(6)){
            pobednik=2
        }
        //3. red
        if(iks.contains(7)&&iks.contains(8)&&iks.contains(9)){
            pobednik=1
        }
        if(oks.contains(7)&&oks.contains(8)&&oks.contains(9)){
            pobednik=2
        }
        //1. kolona
        if(iks.contains(1)&&iks.contains(4)&&iks.contains(7)){
            pobednik=1
        }
        if(oks.contains(1)&&oks.contains(4)&&oks.contains(7)){
            pobednik=2
        }
        //2. kolona
        if(iks.contains(2)&&iks.contains(5)&&iks.contains(8)){
            pobednik=1
        }
        if(oks.contains(2)&&oks.contains(5)&&oks.contains(8)){
            pobednik=2
        }
        //3. kolona
        if(iks.contains(3)&&iks.contains(6)&&iks.contains(9)){
            pobednik=1
        }
        if(oks.contains(3)&&oks.contains(6)&&oks.contains(9)){
            pobednik=2
        }
        //dijagonala 1
        if(iks.contains(1)&&iks.contains(5)&&iks.contains(9)){
            pobednik=1
        }
        if(oks.contains(1)&&oks.contains(5)&&oks.contains(9)){
            pobednik=2
        }
        //dijagonala 2
        if(iks.contains(3)&&iks.contains(5)&&iks.contains(7)){
            pobednik=1
        }
        if(oks.contains(3)&&oks.contains(5)&&oks.contains(7)){
            pobednik=2
        }

        if(pobednik!=-1){
            if(pobednik==1){
                Toast.makeText(this,"X je pobednik", Toast.LENGTH_LONG).show()
                brojPobeda1++


            }else{
                Toast.makeText(this,"O je pobednik", Toast.LENGTH_LONG).show()
                brojPobeda2++

            }

            kraj()

        }


    }

    fun kraj(){
        var pomoc: Button =findViewById(R.id.bu1)
        pomoc.isEnabled=false


        pomoc=findViewById(R.id.bu2)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu3)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu4)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu5)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu6)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu7)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu8)
        pomoc.isEnabled=false

        pomoc=findViewById(R.id.bu9)
        pomoc.isEnabled=false
    }

    fun restartuj(view: View) {
        pobednik=-1
        ispocetka=0

        val tekstId: TextView =findViewById(R.id.text_view_id)
        tekstId.text="Broj pobeda X: $brojPobeda1\n" + "Broj pobeda O: $brojPobeda2"



        var pomoc: Button =findViewById(R.id.bu1)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu2)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu3)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu4)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu5)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu6)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu7)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu8)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        pomoc=findViewById(R.id.bu9)
        pomoc.isEnabled=true
        pomoc.text=" "
        pomoc.setBackgroundColor(Color.parseColor("#FFFFFF"))

        iks.clear()
        oks.clear()

    }
    //da predje na poslednji ekran
    fun izlaz(view:View){
        var gotovo = Intent(this, ZavrsnaAktivnost::class.java)
        gotovo.putExtra("pobedeX", brojPobeda1)
        gotovo.putExtra("pobedeO", brojPobeda2)
        startActivity(gotovo)
    }

}