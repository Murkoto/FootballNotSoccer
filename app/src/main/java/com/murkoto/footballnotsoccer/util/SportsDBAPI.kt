package com.murkoto.footballnotsoccer.util

import com.murkoto.footballnotsoccer.model.Events
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SportsDBAPI {

    @GET("eventsnextleague.php")
    fun getFutureEvents(@Path("id") id: String): Call<Events>

}