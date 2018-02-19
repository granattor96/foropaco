package net.azarquiel.foropaco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import net.azarquiel.foropaco.api.foropacoTemasGet
import net.azarquiel.foropaco.api.foropacoUsersGet
import net.azarquiel.foropaco.model.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG="**Darkness**"
    }
    private lateinit var UsuariosGET:ArrayList<Usuario>
    private lateinit var ThemesGET:ArrayList<Tema>
    private val foroPacoUsersGet by lazy{
        foropacoUsersGet.create()
    }
    private val foroPacoThemesGet by lazy {
        foropacoTemasGet.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadThemes()
    }
    private fun loadThemes(){
        foroPacoThemesGet.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { themmes ->
                            this.ThemesGET = themmes.themes.temas as ArrayList<Tema>

                            showTemas()
                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                            Log.e(TAG,error.message)
                        }
                )
    }
    private fun showTemas(){
        Log.d(TAG,"temas")
        Log.d(TAG,ThemesGET.get(0)._id)
        Log.d(TAG,ThemesGET.get(ThemesGET.size-1).toString())
    }
}
