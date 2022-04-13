package fr.epf.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class CreerUneColocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creer_une_colocation)

        val nomColocataire = findViewById<EditText>(R.id.text_input_nom_colocataire1)
        val affichageNomColocataire = findViewById<TextView>(R.id.text_affichage_nom_colocataire)
        val ajouterAutreColocataire = findViewById<Button>(R.id.ajouter_un_autre_colocataire)

        ajouterAutreColocataire.setOnClickListener {
            //Log.d("patrick", "${nomColocataire.text}")
            affichageNomColocataire.text = "${affichageNomColocataire.text} ${nomColocataire.text}"
            //Log.d("patrick", "${affichageNomColocataire.text}")
            nomColocataire.text = null
            //Log.d("patrick", "${nomColocataire.text}")

        }

    }
}

//Il faut maintenant créer un liste de coloc, ie quand j'appuie sur le bouton ajouter, les inputs créé un nouveau coloc dans cette coloc