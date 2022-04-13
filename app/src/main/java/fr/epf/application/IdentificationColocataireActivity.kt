package fr.epf.application

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IdentificationColocataireActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identification_colocataire)

        val boutonColocataire1 = findViewById<Button>(R.id.btn_coloc1)
        val boutonColocataire2 = findViewById<Button>(R.id.btn_coloc2)
        val boutonColocataire3 = findViewById<Button>(R.id.btn_coloc3)

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


        Log.d("patrick", "${boutonColocataire1.text} ${boutonColocataire2.text} ${boutonColocataire3.text}")
    }
}