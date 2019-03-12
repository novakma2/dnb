package com.teamsix.dnbxchange.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.teamsix.dnbxchange.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun onClickExchange(v: View) {

        val intent = Intent(this, ExchangeActivity::class.java).apply {

        }
        startActivity(intent)


    }


}

class Countries(val name: String, val iso: String, val path: String)

fun main(parameter: Array<String>) {
    val people: Array<Countries> = arrayOf(
        Countries("Canada", "CA", "canada_flag_48"),
        Countries("Czech Republic", "CZ", "czech_republic_flag_48"),
        Countries("European Union", "  EU", "european_union_flag_48"),
        Countries("Iceland", "IS", "iceland_flag_48"),
        Countries("Japan", "JP", "japan_flag_48"),
        Countries("Norway", "NO", "norway_flag_48"),
        Countries("Poland", "PL", "poland_flag_48"),
        Countries("Sweden", "SE", "sweden_flag_48"),
        Countries("United Kingdom", "UK", "united_kingdom_flag_48"),
        Countries("United States", "US", "united_states_flag_48")
    )


}


