package tg.intaonline.intaonline.ApiClient.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    fun getretrofit(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return  Retrofit.Builder()
            .baseUrl("https://apiintaonline.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}