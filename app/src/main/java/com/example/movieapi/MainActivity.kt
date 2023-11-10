package com.example.movieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding : ActivityMainBinding
    var token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YTk5YjZkMDcxZjkwMjY3MGFmYWQ1ZTNlZmZkMmZiNiIsInN1YiI6IjYzZDc2YjY1MjBlNmE1MDA4OTBkNTkyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.zFJRzC2mOd0UKf3yhigXoQrd2wHD9TzZSBWmDxEZMyE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getNowplainging("Bearer $token").enqueue(object : Callback<NowPlayingModel> {
            override fun onResponse(
                call: Call<NowPlayingModel>,
                response: Response<NowPlayingModel>
            ) {
                var list = response.body()?.results
                binding.rcvNowPlaying.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rcvNowPlaying.adapter = NowplayingAdepter(list)
            }

            override fun onFailure(call: Call<NowPlayingModel>, t: Throwable) {

            }

        })


    }
}