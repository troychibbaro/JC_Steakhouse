package com.example.jcsteakhouse.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jcsteakhouse.data.Product

@Composable
fun PopularProduct(data: Product){
    Card(shape = ShapeDefaults.Large, modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp), colors = CardDefaults.cardColors(
        MaterialTheme.colorScheme.primary), elevation = CardDefaults.cardElevation(16.dp, 24.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier
                .padding(16.dp)) {
                data.name?.let { Text(text = it, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) }
                data.price?.let { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
            }

            Button(onClick = {/***/}, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary), modifier = Modifier
                .padding(end = 8.dp)) {
                Text("Add to Cart")
            }
        }
    }
}

@Composable
fun PopularProductsView(data: ArrayList<Product>){
    Card{
        LazyRow {
            items(data){ item ->
                PopularProduct(data = item)
            }
        }
    }
}