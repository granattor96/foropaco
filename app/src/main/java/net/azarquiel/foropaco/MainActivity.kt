package net.azarquiel.foropaco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.azarquiel.foropaco.api.foropacoTemasGet
import net.azarquiel.foropaco.api.foropacoUsersGet
import net.azarquiel.foropaco.model.Themes
import net.azarquiel.foropaco.model.Usuarios

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG="**Darkness**"
    }
    private lateinit var UsuariosGET:ArrayList<Usuarios>
    private lateinit var ThemesGET:ArrayList<Themes>
    private val foroPacoUsersGet by lazy{
        foropacoUsersGet.create()
    }
    private val foroPacoThemesGet by lazy {
        foropacoTemasGet.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
