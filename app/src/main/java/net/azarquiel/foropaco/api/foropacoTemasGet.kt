package net.azarquiel.foropaco.api

import android.database.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Agustin on 19/02/2018.
 */
interface foropacoTemasGet {
    @GET("temas")
    fun getData(): Observable<ResponseBody>

    companion object {
        fun create(): foropacoTemasGet {
            val retrofix= Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://localhost/foroslim/")
                    .build()
            return retrofix.create(foropacoTemasGet::class.java)
        }
    }
}