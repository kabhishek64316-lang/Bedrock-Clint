// RakNet.kt
package com.github.minebedrockmitm

import android.util.Log

object RakNet {
    fun handlePacket(packet: ByteArray) {
        // Handle RakNet packet
        // Intercept and modify packets as needed
        // For example, modify packet data, forward to modules, etc.
        Log.d("RakNet", "Packet intercepted: ${packet.size} bytes")
        // Pass packet to module manager
        ModuleManager.handlePacket(packet)
    }
}