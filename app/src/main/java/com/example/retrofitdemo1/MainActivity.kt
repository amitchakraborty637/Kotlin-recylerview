package com.example.retrofitdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private  var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null
    val users=ArrayList<model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display()
        swiperefresh.setOnRefreshListener {
            clear()
            display()
            swiperefresh.isRefreshing=false
        }
    }


    private fun clear()
    {
        users.clear()
        layoutManager= LinearLayoutManager(this@MainActivity)
        recycleView.layoutManager=layoutManager
        adapter=RecyclerAdapter(users)
        recycleView.adapter=adapter
    }

    private fun display() {
        var url:String="http://192.168.0.104"
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api:testapi=retrofit.create(testapi::class.java)
        var call: Call<List<model>>?=api.display()
        call?.enqueue(object : Callback<List<model>>
        {
            override fun onResponse(call: Call<List<model>>, response: Response<List<model>>) {
                Toast.makeText(this@MainActivity,"success",Toast.LENGTH_LONG).show()
                var str: List<model>? =response.body()
                users.addAll(str!!)
                layoutManager= LinearLayoutManager(this@MainActivity)
                recycleView.layoutManager=layoutManager
                adapter=RecyclerAdapter(users)
                recycleView.adapter=adapter
            }

            override fun onFailure(call: Call<List<model>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }


        )
    }
}