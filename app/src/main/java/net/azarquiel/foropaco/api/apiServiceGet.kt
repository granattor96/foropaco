package net.azarquiel.foropaco.api


import net.azarquiel.foropaco.model.Respuesta
import net.azarquiel.foropaco.model.Tema
import net.azarquiel.foropaco.model.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


/**
 * Created by Agustin on 19/02/2018.
 */
interface apiServiceGet {
    @GET("users")
    fun user():Observable<Respuesta>

    @GET("user/{telefono}")
    fun getUser(@Path("telefono") telefono: String): Observable<Respuesta>

    @GET("tema")
    fun tema(): Observable<Respuesta>

    @GET("tema/{tema}/comentarios")
    fun getTema(@Path("tema") tema: Tema ):Observable<Respuesta>

    companion object {
        fun create(): apiServiceGet {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://172.19.114.2/foroslim/")
                   // .baseUrl("http://www.ies-azarquiel.es/paco/foroslim/")
                    .build()
            return retrofit.create(apiServiceGet::class.java)
        }
    }
}