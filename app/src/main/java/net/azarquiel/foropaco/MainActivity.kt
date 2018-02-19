package net.azarquiel.foropaco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import net.azarquiel.foropaco.api.apiServiceGet
import net.azarquiel.foropaco.model.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG="**Darkness**"
    }
    private lateinit var Temas:ArrayList<Tema>
    private val foroPacoThemesGet by lazy {
        apiServiceGet.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUsers()
    }
    private fun loadUsers(){
        foroPacoThemesGet.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { respuesta ->
                            Log.d(TAG,respuesta.users.toString())

                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                            Log.e(TAG,error.message)
                        }
                )
    }
    private fun showTemas(){
        Log.d(TAG,"temas")
        Log.d(TAG,Temas.get(0)._id)
        Log.d(TAG,Temas.get(Temas.size-1).toString())
    }
}
