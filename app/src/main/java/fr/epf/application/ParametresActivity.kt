package fr.epf.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.epf.application.models.Colocataire
import fr.epf.application.models.Colocation

class ParametresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametres)

    //afficher la position du colocataire connecté ie isSessionActive == true

        var idColocCo: Int = 0;

        // on créé récupére le booleen de la session de 3 colocataires
        for (i in 0..2) {
            val colocataireCo = Colocataire.bdd(3)[i].isSessionActive
            if (colocataireCo) { //si session active alors on sauvegarde l'id
                idColocCo = i
            }
        }

        // on affiche les infos du coloc actif grace à l'id sauvegardé
        val nomTextView =
            findViewById<TextView>(R.id.nom_coloc_value)

        val nom = Colocataire.bdd(3)[idColocCo].nom
        nomTextView.text = nom

        val mailTextView =
            findViewById<TextView>(R.id.mail_coloc_value)

        val mail = Colocataire.bdd(3)[idColocCo].email
        mailTextView.text = mail


        //Le colocataire détient il la couronne ?
        val couronne = Colocataire.bdd(3)[idColocCo].isSuperColoc
        val passerCouronneTextView =
            findViewById<TextView>(R.id.passer_ma_couronne)
        val passerCouronneImageView =
            findViewById<ImageView>(R.id.passer_ma_couronne_image)
        val btnQuitterColoc =
            findViewById<Button>(R.id.btn_quitter_coloc)
        val messageQuitterColoc =
            findViewById<TextView>(R.id.message_quitter_coloc)

        if (!couronne){
            passerCouronneTextView.setVisibility(TextView.INVISIBLE);
            messageQuitterColoc.setVisibility(TextView.INVISIBLE);
            passerCouronneImageView.setVisibility(ImageView.INVISIBLE);
        }else{
            btnQuitterColoc.setEnabled(false)
        }


        //Passer sa couronne bouton
        passerCouronneTextView.setOnClickListener{
            val intent = Intent(this,PasserCouronneActivity::class.java)
            startActivity(intent)
        }

        //Quitter la colonne bouton
        btnQuitterColoc.setOnClickListener{
            val intent = Intent(this,QuitterColocActivity::class.java)
            startActivity(intent)
        }

    }
}