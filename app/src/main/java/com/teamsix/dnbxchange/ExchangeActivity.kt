package com.teamsix.dnbxchange

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.*

class ExchangeActivity : Activity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)
       // Spinner spiner  = clearFindViewById(R.id.countries_spiner)
    }

    fun onClickMain(v: View){

        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)



    }

}
