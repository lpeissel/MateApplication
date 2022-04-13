package fr.epf.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import fr.epf.application.models.Colocataire
import org.w3c.dom.Text

class CreerUneColocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creer_une_colocation)

        var i = 0
        val listColocataire: MutableList<Colocataire> = ArrayList()
        val nomColocataire = findViewById<EditText>(R.id.text_input_nom_colocataire1)
        val emailColocataire = findViewById<EditText>(R.id.text_input_email_colocataire)
        val affichageNomColocataire = findViewById<TextView>(R.id.text_affichage_nom_colocataire)
        val ajouterAutreColocataire = findViewById<Button>(R.id.ajouter_un_autre_colocataire)
        val suivant = findViewById<Button>(R.id.suivant_vers_choisir_colocataire)


        ajouterAutreColocataire.setOnClickListener {
            //Log.d("patrick", "${nomColocataire.text}")
            affichageNomColocataire.text = "${affichageNomColocataire.text} ${nomColocataire.text}"
            //Log.d("patrick", "${affichageNomColocataire.text}")

            val nomColocataireDansListe = nomColocataire.text.toString()
            val emailColocataireDansListe = emailColocataire.text.toString()
            val isSuperColoc = if (i == 0) true else false

            listColocataire.add(Colocataire(nomColocataireDansListe, 100 + i, emailColocataireDansListe, isSuperColoc, false))
            i += 1

            nomColocataire.text = null
            emailColocataire.text = null
            Log.d("patrick", "$listColocataire")
        }

        suivant.setOnClickListener {
            val intent = Intent(this, IdentificationColocataireActivity::class.java )
            intent.putExtra("colocataire1", listColocataire[0].nom)
            intent.putExtra("colocataire2", listColocataire[1].nom)
            intent.putExtra("colocataire3", listColocataire[2].nom)
            startActivity(intent)

        }

    }
}

