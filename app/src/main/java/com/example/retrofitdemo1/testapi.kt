package com.example.retrofitdemo1

import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface testapi {


    @GET("/view/fetch.php")
fun display():Call<List<model>>

}