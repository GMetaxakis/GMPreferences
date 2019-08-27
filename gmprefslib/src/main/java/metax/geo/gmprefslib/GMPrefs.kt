package metax.geo.gmprefslib

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.annotation.StringRes

class GMPrefs(
    private val preferences: SharedPreferences,
    private val resources: Resources
) {
    private fun key(@StringRes key: Int): String = resources.getString(key)

    fun getBoolean(@StringRes bool: Int, defValue: Boolean): Boolean =
        preferences.getBoolean(key(bool), defValue)

    fun getString(@StringRes string: Int, defValue: String): String? =
        preferences.getString(key(string), defValue)

    fun getInt(@StringRes int: Int, defValue: Int): Int =
        preferences.getInt(key(int), defValue)

    fun getLong(@StringRes long: Int, defValue: Long): Long =
        preferences.getLong(key(long), defValue)

    fun getFloat(@StringRes float: Int, defValue: Float): Float =
        preferences.getFloat(key(float), defValue)

    fun setBoolean(@StringRes bool: Int, value: Boolean) {
        preferences.edit().putBoolean(key(bool), value).apply()
    }

    fun setString(@StringRes string: Int, value: String) {
        preferences.edit().putString(key(string), value).apply()
    }

    fun setInt(@StringRes int: Int, value: Int) {
        preferences.edit().putInt(key(int), value).apply()
    }

    fun setLong(@StringRes long: Int, value: Long) {
        preferences.edit().putLong(key(long), value).apply()
    }

    fun setFloat(@StringRes float: Int, value: Float) {
        preferences.edit().putFloat(key(float), value).apply()
    }

    fun clear() {
        preferences.edit().clear().apply()
    }

    companion object {
        fun getInstance(context: Context, @StringRes fileName: Int): GMPrefs =
            GMPrefs(
                context.getSharedPreferences(context.getString(fileName), Context.MODE_PRIVATE),
                context.resources
            )
    }
}