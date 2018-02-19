package net.azarquiel.foropaco.model

/**
 * Created by Agustin on 19/02/2018.
 */
data class Respuesta(val user:User, val users:ArrayList<User>, val tema: Tema, val temas: List<Tema>)
data class User(val telefono:String, val nick:String)
data class Tema(val _id:String,val descripcion:String)
