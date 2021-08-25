package com.adromindts.bjp.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adromindts.bjp.R
import com.adromindts.bjp.model.PeopleModel
import com.adromindts.bjp.utils.Constant
import com.adromindts.bjp.view.adapter.CustomAlertDialog
import com.adromindts.bjp.view.adapter.FruitAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_scan.*


class MainActivity : AppCompatActivity() {

    lateinit var arrayList: ArrayList<PeopleModel.Sheet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = getString(R.string.search_title)
        getModel()
    }

    private fun getModel() {

        runOnUiThread {
            val peopleList =
                Gson().fromJson(Constant.readJSONFromAsset(this), PeopleModel::class.java)
            val sheet = peopleList.Sheet1

            val newPeopleList =
                Gson().fromJson(Constant.readJSONFromAssetNewList(this), PeopleModel::class.java)
            val sheet2 = newPeopleList.Sheet1
            arrayList = ArrayList()
            arrayList.addAll(sheet)
            arrayList.addAll(sheet2)
        }

        val adapter = FruitAdapter(this, R.layout.dropdown_menu_popup_item, arrayList,empty)
        filled_exposed_dropdown.threshold = 3
        filled_exposed_dropdown.setAdapter(adapter)


        filled_exposed_dropdown.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


                val people = arrayList.get(p2)
                try {
                    val customAlertDialog = CustomAlertDialog.newInstance(
                        this@MainActivity
                    )
                    customAlertDialog.showDetails(people)

                    Constant.hideKeyBoard(this@MainActivity,p1!!)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }
}
