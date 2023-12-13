package com.example.mockserverpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.mockserverpoc.model.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        apiInterface = NetworkClient.getClient().create(ApiInterface::class.java)
        button.setOnClickListener {
            val call = apiInterface.doGetUserList()

            call?.enqueue(object : Callback<UserList?> {
                override fun onResponse(call: Call<UserList?>?, response: Response<UserList?>?) {
                    Log.d("API response", response?.body().toString())
                    Toast.makeText(this@MainActivity, response?.body().toString(), Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UserList?>?, t: Throwable?) {
                    Log.d("API response", t?.message.toString())
                    Toast.makeText(this@MainActivity, t?.message.toString(), Toast.LENGTH_LONG)
                        .show()
                }

            })
        }
    }
}