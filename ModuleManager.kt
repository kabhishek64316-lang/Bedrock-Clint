// ModuleManager.kt
package com.github.minebedrockmitm

object ModuleManager {
    private val modules = mutableListOf<Module>()

    init {
        // Initialize modules
        modules.add(KillAura())
        modules.add(Flight())
        modules.add(Speed())
        modules.add(NoFall())
        modules.add(Scaffold())
        modules.add(Velocity())
        modules.add(ESP())
        modules.add(XRay())
        modules.add(Nuker())
    }

    fun handlePacket(packet: ByteArray) {
        modules.forEach { module ->
            if (module.isEnabled) {
                module.handlePacket(packet)
            }
        }
    }

    interface Module {
        val isEnabled: Boolean
        fun handlePacket(packet: ByteArray)
    }
}