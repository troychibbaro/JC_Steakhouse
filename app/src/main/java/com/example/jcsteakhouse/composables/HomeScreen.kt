package com.example.jcsteakhouse.composables

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcsteakhouse.R
import com.example.jcsteakhouse.composables.generic.CroppedImage
import com.example.jcsteakhouse.composables.generic.Shape
import com.example.jcsteakhouse.data.HeaderProduct
import com.example.jcsteakhouse.ui.theme.JCSteakhouseTheme
import com.example.jcsteakhouse.utilities.Utilities
import com.google.gson.Gson

@Composable
fun HeaderProductItem(data: HeaderProduct, context: Context){
    Card(shape = ShapeDefaults.Large, modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp), colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary), elevation = CardDefaults.cardElevation(24.dp, 36.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically){
            val icon = data.icon?.let { Utilities.mapIconKeyToResource(it, context) }

            if (icon != null) {
                Icon(icon, contentDescription = "Test", modifier = Modifier
                    .padding(8.dp))
            }

            Column(modifier = Modifier
                .padding(16.dp)) {
                data.name?.let { Text(it, style = MaterialTheme.typography.labelLarge) }
                data.price?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
            }


            Button(onClick = {/***/}, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary), modifier = Modifier
                .padding(end = 8.dp)) {
                Text("Buy")
            }
        }
    }
}

@Composable
fun HeaderTitle(title: String){
    Card(elevation = CardDefaults.cardElevation(24.dp, 36.dp), colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            Box(modifier = Modifier.align(CenterHorizontally)) {
                CroppedImage(shape = Shape.CIRCLE, imageRes = R.drawable.steak, borderWidth = 2.dp)
            }
        }
    }

}

@Preview
@Composable
fun HeaderPreview(){
    JCSteakhouseTheme {
        HeaderTitle(title = "A Header")
    }
}

@Composable
fun ScrollableHorizontalView(data: ArrayList<HeaderProduct>, context: Context){
    LazyRow {
        items(data){ item ->
            HeaderProductItem(data = item, context = context)
        }
    }
}