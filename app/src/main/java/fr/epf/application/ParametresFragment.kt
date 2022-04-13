package fr.epf.application

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.epf.application.models.Colocataire


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ParametresFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ParametresFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parametres, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        val nomTextView=
            view.findViewById<TextView>(R.id.nom_coloc_value)

        val nom = Colocataire.bdd(3)[idColocCo].nom
        nomTextView.text = nom

        val mailTextView =
            view.findViewById<TextView>(R.id.mail_coloc_value)

        val mail = Colocataire.bdd(3)[idColocCo].email
        mailTextView.text = mail


        //Le colocataire détient il la couronne ?
        val couronne = Colocataire.bdd(3)[idColocCo].isSuperColoc
        val passerCouronneTextView = view.findViewById<TextView>(R.id.passer_ma_couronne)
        val passerCouronneImageView =
            view.findViewById<ImageView>(R.id.passer_ma_couronne_image)
        val btnQuitterColoc =
            view.findViewById<Button>(R.id.btn_quitter_coloc)
        val messageQuitterColoc =
            view.findViewById<TextView>(R.id.message_quitter_coloc)

        if (!couronne){
            passerCouronneTextView.setVisibility(TextView.INVISIBLE);
            messageQuitterColoc.setVisibility(TextView.INVISIBLE);
            passerCouronneImageView.setVisibility(ImageView.INVISIBLE);
        }else{
            btnQuitterColoc.setEnabled(false)
        }

        val listColocataire: MutableList<Colocataire> = ArrayList()

        //Passer sa couronne bouton
        passerCouronneTextView.setOnClickListener{
            val intent = Intent(context,PasserCouronneActivity::class.java)
            //comment ouvrir un nouveau fragment ??
            intent.putExtra("colocataire1", listColocataire[0].nom)
            intent.putExtra("colocataire2", listColocataire[1].nom)
            intent.putExtra("colocataire3", listColocataire[2].nom)
            startActivity(intent)
        }

        //Quitter la colonne bouton
        btnQuitterColoc.setOnClickListener{
            val intent = Intent(context,QuitterColocActivity::class.java)
            startActivity(intent)
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ParametresFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ParametresFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }


}