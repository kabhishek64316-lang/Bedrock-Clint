// ClickGUI.kt
package com.github.minebedrockmitm.gui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClickGUI() {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { /* Toggle KillAura */ }) {
            Text("KillAura")
        }
        Button(onClick = { /* Toggle Flight */ }) {
            Text("Flight")
        }
        // Add more buttons for other modules
    }
}