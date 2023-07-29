package com.example.jcsteakhouse.data

import com.google.gson.annotations.SerializedName

data class AllProducts(
    @SerializedName("items") val items: ArrayList<Product>
)

data class Product(
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("icon") val icon: String?
)

data class ReviewData(
    @SerializedName("name") val name: String,
    @SerializedName("review") val review: String,
    @SerializedName("rating") val rating: Double
)