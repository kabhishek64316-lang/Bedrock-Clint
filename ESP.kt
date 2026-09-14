// ESP.kt
package com.github.minebedrockmitm.modules

import com.github.minebedrockmitm.ModuleManager

class ESP : ModuleManager.Module {
    override val isEnabled: Boolean = true

    override fun handlePacket(packet: ByteArray) {
        // Handle ESP logic
        // Example: Render entity outlines
    }
}