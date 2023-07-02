package com.example.aadk3sampleapp3.networkUtils

import com.google.gson.annotations.SerializedName

data class BreedDetail(

    @SerializedName("name")
    val name: String,

    @SerializedName("breed_group")
    val category: String,

    @SerializedName("origin")
    val origin: String,

    @SerializedName("image")
    val imageReference: DogImage
)

data class DogImage(

    @SerializedName("url")
    val imageUrl: String
)

/*

{
    "name": "Affenpinscher",
    "breed_group": "Toy",
    "origin": "Germany, France",
    "image": {
      "url": "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg"
    }
  }

 */
