package fr.epf.application.models

data class Colocataire(
    var nom: String? = null,
    val id: Int? = null,
    val email: String? = null
){

    companion object{
        fun bdd(nb: Int =3) =
            (1..nb).map{

                Colocataire(
                    "Colocataire$it", 200 + it, "colocataire$it@gmail.com"
                )
            }
    }

}