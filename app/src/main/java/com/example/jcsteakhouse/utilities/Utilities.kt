package com.example.jcsteakhouse.utilities

import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.content.ContextCompat
import com.example.jcsteakhouse.R
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

object Utilities {
    fun readJson(filename: String, context: Context): String?{
        val content: String
        try {
            content = context.assets.open("json/$filename").bufferedReader().use {it.readText()}
        } catch (e: IOException){
            e.printStackTrace()
            return null
        }

        Log.d("TROY", content)
        return content
    }
}