package com.example.aadk3sampleapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aadk3sampleapp3.databinding.ActivityMainBinding
import com.example.aadk3sampleapp3.networkUtils.BreedDetail
import com.example.aadk3sampleapp3.networkUtils.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var breedList = listOf<BreedDetail>()
    private lateinit var adapter: DogBreedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DogBreedAdapter(this, breedList)

        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rv.adapter = adapter

        binding.btn.setOnClickListener {
            binding.pb.visibility = View.VISIBLE
            // Fetch the details using the retrofit call
            api.fetchDogBreeds().enqueue(object : Callback<List<BreedDetail>?> {
                override fun onResponse(
                    call: Call<List<BreedDetail>?>,
                    response: Response<List<BreedDetail>?>
                ) {
                    if (response.isSuccessful) {
                        binding.pb.visibility = View.GONE
                        binding.rv.visibility = View.VISIBLE
                        binding.btn.visibility = View.GONE

                        val data = response.body() ?: listOf()
                        adapter.refreshList(data)
                    }
                }

                override fun onFailure(call: Call<List<BreedDetail>?>, t: Throwable) {
                    binding.pb.visibility = View.GONE
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}

// Database -> [user1, user2, user3 .... ]
// Hosted somewhere on the cloud [so that it can be accessed on a Network connection] -> Server
// Backend -> Interacts with these servers and this DB, works as a bridge between a User and the Cloud
// Flow of Data is done using certain APIs
// GET, POST, FETCH, PUT
// insertContacts(list) {  } -> http://www.xyz.com/getAllContacts/ -> Retrofit Library (HTTP Request)

