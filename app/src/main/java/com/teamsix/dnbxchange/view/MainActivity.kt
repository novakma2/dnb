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

