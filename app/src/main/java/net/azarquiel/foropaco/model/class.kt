package net.azarquiel.foropaco.model

/**
 * Created by Agustin on 19/02/2018.
 */
data class Users(val users: Usuarios)
data class Usuarios(val usuarios: List<Users>)
data class Usuario(val telefono:String, val nick:String)

data class Themes(val themes: Temas)
data class Temas(val temas:List<Themes>)
data class Tema(val _id:String,val descripcion:String)
