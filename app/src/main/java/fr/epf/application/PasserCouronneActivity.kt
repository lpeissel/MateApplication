package fr.epf.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PasserCouronneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passer_couronne)

        val boutonColocataire1 = findViewById<Button>(R.id.btn_couronne_coloc1)
        val boutonColocataire2 = findViewById<Button>(R.id.btn_couronne_coloc2)
        val boutonColocataire3 = findViewById<Button>(R.id.btn_couronne_coloc3)


        if (intent.hasExtra("colocataire1")) {
            boutonColocataire1.text =
                intent.getStringExtra("colocataire1").toString()
        }

        if (intent.hasExtra("colocataire2")) {
            boutonColocataire2.text =
                intent.getStringExtra("colocataire2").toString()
        }

        if (intent.hasExtra("colocataire3")) {
            boutonColocataire3.text =
                intent.getStringExtra("colocataire3").toString()
        }


    }
}