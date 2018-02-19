package net.azarquiel.foropaco.model

/**
 * Created by Agustin on 19/02/2018.
 */
data class Usuarios(val users: Users)
data class Users(val telefono: String,val nick:String)

data class Themes(val temas: Temas)
data class Temas(val _id:String, val descripcion:String)