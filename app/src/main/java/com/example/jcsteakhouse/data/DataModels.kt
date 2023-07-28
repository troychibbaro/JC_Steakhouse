package com.example.jcsteakhouse.data

import com.google.gson.annotations.SerializedName

data class AllProducts(
    @SerializedName("items") val items: ArrayList<HeaderProduct>
)

data class HeaderProduct(
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("icon") val icon: String?
)