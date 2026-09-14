// ProfileManager.kt
package com.github.minebedrockmitm.profiles

import android.content.Context
import android.content.SharedPreferences
import com.github.minebedrockmitm.ModuleManager
import org.json.JSONObject

object ProfileManager {
    private lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences("profiles", Context.MODE_PRIVATE)
    }

    fun loadProfile(profileName: String) {
        val jsonString = sharedPreferences.getString(profileName, null)
        jsonString?.let {
            val json = JSONObject(it)
            ModuleManager.modules.forEach { module ->
                module.isEnabled = json.optBoolean(module.javaClass.simpleName, false)
            }
        }
    }

    fun saveProfile(profileName: String) {
        val json = JSONObject()
        ModuleManager.modules.forEach { module ->
            json.put(module.javaClass.simpleName, module.isEnabled)
        }
        sharedPreferences.edit().putString(profileName, json.toString()).apply()
    }
}