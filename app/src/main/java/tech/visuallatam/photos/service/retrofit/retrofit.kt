package tech.visuallatam.photos.service.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response
import tech.visuallatam.photos.database.entities.photo


const val BASE_URL = "https://picsum.photos/"
interface retrofit {

    @GET("/v2/list?limit=")
    fun getfotos(): Deferred<Response<List<photo>>>

    companion object {
        var INSTANCE: retrofit? = null

        fun getRetrofitInstance() : retrofit{
            if(INSTANCE != null) return INSTANCE!!
            else{
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(retrofit::class.java)
                return INSTANCE!!
            }
        }

    }

}