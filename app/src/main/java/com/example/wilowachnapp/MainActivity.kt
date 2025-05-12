package com.example.wilowachnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wilowachnapp.navigation.MyApp
import com.example.wilowachnapp.ui.theme. WilowachnAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WilowachnAppTheme {
                MyApp()
            }
        }
    }
}
