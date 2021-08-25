package com.adromindts.bjp.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.io.InputStream


object Constant {

    fun hideKeyBoard(context: Context,view: View)
    {
        val imm: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun readJSONFromAsset(context: Context): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("peoplenew.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun readJSONFromAssetNewList(context: Context): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("new_list.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}