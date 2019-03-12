package com.teamsix.dnbxchange.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.teamsix.dnbxchange.R
import com.teamsix.dnbxchange.model.SharedValue
import kotlinx.android.synthetic.main.activity_exchange.*


class ExchangeActivity : FragmentActivity() {
    lateinit var host: NavHostFragment
    private lateinit var sharedValue: SharedValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)
        host = supportFragmentManager
            .findFragmentById(R.id.container) as NavHostFragment? ?: return
        this.let {
            sharedValue = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
                .create(SharedValue::class.java)
            sharedValue.number.observe(this.host,Observer {
                it?.let {
                    txtConvertedValue.text = it.toEngineeringString()
                }
            })
        }

        bottomNav.setupWithNavController(host.navController)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}

