package fr.epf.application.models

class Colocation(
    var nom: String? = null,
    var id: Int? = null,
    var colocataire: List<Colocataire>? = null,
    ){

    companion object{
        fun bdd(nb: Int =3) =
            (1..nb).map{

                //val coloc = Colocataire.bdd(3)
                val colocvide = Colocataire.bdd()
                Colocation(
                    "Colocation$it", 100 + it, colocvide
                )
            }
    }

}








