package com.example.jcsteakhouse.composables.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcsteakhouse.R
import com.example.jcsteakhouse.composables.generic.CroppedImage
import com.example.jcsteakhouse.composables.generic.Shape
import com.example.jcsteakhouse.data.ReviewData
import com.example.jcsteakhouse.ui.theme.JCSteakhouseTheme
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

@Composable
fun HomeSection(title: String, content: @Composable (Modifier) -> Unit){
    Card(modifier = Modifier.padding(8.dp)){
        Column {
            Row(Modifier.fillMaxWidth()) {
                Text(text = title, modifier = Modifier
                    .align(CenterVertically)
                    .padding(top = 8.dp, start = 24.dp)
                    .weight(1f), color = MaterialTheme.colorScheme.tertiary, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Medium)
            }
            content(Modifier.padding(8.dp))
        }
    }
}

@Composable
fun HeaderTitle(title: String){
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.shadow(16.dp)) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 28.sp,
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

@Composable
fun Review(name: String, reviewBody: String, rating: Double){
    Card(shape = ShapeDefaults.Large,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(16.dp, 24.dp)) {
            Row {
                Text(text = rating.toString(),
                    modifier = Modifier.padding(8.dp).align(CenterVertically),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.tertiaryContainer)
                Column(modifier = Modifier.align(CenterVertically).padding(8.dp)){
                    Text(text = name, fontWeight = FontWeight.Medium, fontSize = 28.sp)
                    Text(text = reviewBody)
                }
            }
    }
}

@Composable
fun ReviewList(reviews: ArrayList<ReviewData>){
    LazyRow{
        items(reviews){data ->
            Review(data.name, data.review, data.rating)
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

@Preview
@Composable
fun ReviewPreview(){
    JCSteakhouseTheme {
        Review("Kimberly O.", "It was fantastic!", 4.6)
    }
}