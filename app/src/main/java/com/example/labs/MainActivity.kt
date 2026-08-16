package com.example.labs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import com.example.labs.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAB6_12345", "onCreate")
        setContent {
            Scaffold { innerPadding ->
                FeedScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }

    override fun onStart() { super.onStart(); Log.d("LAB6_12345", "onStart") }
    override fun onResume() { super.onResume(); Log.d("LAB6_12345", "onResume") }
    override fun onPause() { super.onPause(); Log.d("LAB6_12345", "onPause") }
    override fun onStop() { super.onStop(); Log.d("LAB6_12345", "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("LAB6_12345", "onDestroy") }
}
