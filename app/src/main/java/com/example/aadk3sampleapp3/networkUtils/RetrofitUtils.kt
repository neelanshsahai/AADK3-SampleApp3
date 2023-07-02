package com.example.aadk3sampleapp3.networkUtils

import com.example.aadk3sampleapp3.BASE_URL
import com.example.aadk3sampleapp3.BREEDS_ENDPOINT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DogDataService {

    @GET(BREEDS_ENDPOINT)
    fun fetchDogBreeds(): Call<List<BreedDetail>>

}

// Lazy Initialisation
// You can tell how to initialise but the object will only be initialised when it is first called
val api: DogDataService by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)

        // Added client in the Doubts Time
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                .build()
        )

        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogDataService::class.java)
}
