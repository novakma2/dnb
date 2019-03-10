package com.teamsix.dnbxchange

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_exchange.*

class ExchangeActivity : Activity(),AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)


       

    }


    fun onClickMain(v: View){

        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)





    }

}

class Countries1 (val name: String, val iso: String, val path: String) {



}

fun main (parameter: Array <String>) {
    val countries: Array <Countries> = arrayOf (
        Countries ("Canada", "CA","canada_flag_48"),
        Countries ("Czech Republic", "CZ","czech_republic_flag_48"),
        Countries ("European Union", "  EU","european_union_flag_48"),
        Countries ("Iceland", "IS","iceland_flag_48"),
        Countries ("Japan", "JP","japan_flag_48"),
        Countries ("Norway", "NO","norway_flag_48"),
        Countries ("Poland", "PL","poland_flag_48"),
        Countries ("Sweden", "SE","sweden_flag_48"),
        Countries ("United Kingdom", "UK","united_kingdom_flag_48"),
        Countries ("United States", "US","united_states_flag_48"))



}
