package net.azarquiel.foropaco.api


import net.azarquiel.foropaco.model.Themes
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable


/**
 * Created by Agustin on 19/02/2018.
 */
interface foropacoTemasGet {
    @GET("temas")
    fun getData(): Observable<Themes>
    companion object {
        fun create(): foropacoTemasGet {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://localhost/")
                    .build()
            return retrofit.create(foropacoTemasGet::class.java)
        }
    }
}