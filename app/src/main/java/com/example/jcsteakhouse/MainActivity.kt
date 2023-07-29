package com.example.jcsteakhouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import com.example.jcsteakhouse.composables.PopularProductsView
import com.example.jcsteakhouse.composables.home.HeaderTitle
import com.example.jcsteakhouse.composables.home.HomeSection
import com.example.jcsteakhouse.data.AllProducts
import com.example.jcsteakhouse.ui.theme.JCSteakhouseTheme
import com.example.jcsteakhouse.utilities.Utilities
import com.example.jcsteakhouse.viewmodels.home.HomeViewModel
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm: HomeViewModel by viewModels()
        vm.setInitialPopularProducts(Gson().fromJson(Utilities.readJson("hot_items.json", applicationContext), AllProducts::class.java).items)

        setContent {
            JCSteakhouseTheme {
                Surface {
                    Column {
                        HeaderTitle(title = "Welcome to JC Steakhouse")

                        vm.popularProducts.value?.let {products ->
                            HomeSection(title = "Today's popular products") {
                                PopularProductsView(data = products)
                            }
                        }

                        HomeSection(title = "See what our customers are saying") {

                        }
                    }
                }
            }
        }
    }
}

