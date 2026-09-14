// NovaVpnService.kt
package com.github.minebedrockmitm

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import android.os.Build
import android.util.Log
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.ByteBuffer

class NovaVpnService : VpnService() {
    private lateinit var tunFileDescriptor: ParcelFileDescriptor
    private lateinit var tunInputStream: FileInputStream
    private lateinit var tunOutputStream: FileOutputStream
    private lateinit var buffer: ByteBuffer

    override fun onCreate() {
        super.onCreate()
        buffer = ByteBuffer.allocate(32767)
        val builder = Builder()
        builder.setSession("NovaVPN")
        builder.addAddress("10.0.0.2", 24)
        builder.addRoute("0.0.0.0", 0)
        builder.setMtu(1500)
        builder.setConfigureIntent(Intent(android.provider.Settings.ACTION_VPN_SETTINGS))
        tunFileDescriptor = builder.establish()
        tunInputStream = tunFileDescriptor.fileInputStream
        tunOutputStream = tunFileDescriptor.fileOutputStream
        Thread { readPackets() }.start()
    }

    private fun readPackets() {
        while (true) {
            val bytesRead = tunInputStream.read(buffer.array(), 0, buffer.capacity())
            if (bytesRead > 0) {
                buffer.position(0)
                buffer.limit(bytesRead)
                val packet = buffer.array().copyOf(bytesRead)
                RakNet.handlePacket(packet)
                buffer.clear()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        tunInputStream.close()
        tunOutputStream.close()
        tunFileDescriptor.close()
    }
}