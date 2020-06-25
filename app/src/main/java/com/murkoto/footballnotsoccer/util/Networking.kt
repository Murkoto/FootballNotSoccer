package com.murkoto.footballnotsoccer.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Networking {

    val sportsDBAPI: SportsDBAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(SportsDBAPI::class.java)
    }

}