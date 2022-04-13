package fr.epf.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import fr.epf.application.models.Colocataire

class QuitterColocActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quitter_coloc)


        //Si user clique sur oui alors on le supprime de la bdd à relier au BACK
            //on supprime les données : voir avec Back comment faire
        Toast.makeText(this,R.string.colocSupp, Toast.LENGTH_LONG).show()
        val btnQuitterOuiColoc =
            findViewById<Button>(R.id.btn_quitter_oui)

        btnQuitterOuiColoc.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


        //si user clique sur annuler alors il retourne à la page paramètre
        val btnAnnulerQuitterColoc =
            findViewById<Button>(R.id.btn_annuler_quitter)

        btnAnnulerQuitterColoc.setOnClickListener{
            val intent = Intent(this,ParametresActivity::class.java)
            startActivity(intent)
        }

    }
}