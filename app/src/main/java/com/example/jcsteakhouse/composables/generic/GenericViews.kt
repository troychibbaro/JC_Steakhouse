package com.example.jcsteakhouse.composables.generic

import androidx.annotation.IdRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jcsteakhouse.R
import com.example.jcsteakhouse.ui.theme.JCSteakhouseTheme

enum class Shape {
    CIRCLE,
    ROUNDED_SQUARE
}

@Composable
fun CroppedImage(shape: Shape, imageRes: Int, borderWidth: Dp = 0.dp){
    val cropShape = when(shape){
        Shape.CIRCLE -> CircleShape
        Shape.ROUNDED_SQUARE -> RoundedCornerShape(16.dp)
    }

    Image(
        painter = painterResource(imageRes),
        contentScale = ContentScale.Crop,
        contentDescription = "A Steak",
        modifier = Modifier
            .size(80.dp)
            .clip(cropShape)
            .border(BorderStroke(borderWidth, MaterialTheme.colorScheme.tertiary), cropShape))
}

@Preview
@Composable
fun ImagePreview(){
    JCSteakhouseTheme {
        CroppedImage(shape = Shape.CIRCLE, imageRes = R.drawable.steak, borderWidth = 2.dp)
    }
}