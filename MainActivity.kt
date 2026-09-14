// MainActivity.kt
package com.github.minebedrockmitm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.github.minebedrockmitm.gui.ClickGUI
import com.github.minebedrockmitm.profiles.ProfileManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProfileManager.initialize(this)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ClickGUI()
                }
            }
        }
        startService(Intent(this, NovaVpnService::class.java))
    }
}