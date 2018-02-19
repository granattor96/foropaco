package net.azarquiel.foropaco.api


import net.azarquiel.foropaco.model.Respuesta
import net.azarquiel.foropaco.model.Tema
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable


/**
 * Created by Agustin on 19/02/2018.
 */
interface apiServiceGet {
    @GET("users")
    fun user():Observable<Respuesta>

    @GET("temas")
    fun getData(): Observable<Respuesta>

    companion object {
        fun create(): apiServiceGet {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://172.19.114.2/foroslim/")
                    .build()
            return retrofit.create(apiServiceGet::class.java)
        }
    }
}