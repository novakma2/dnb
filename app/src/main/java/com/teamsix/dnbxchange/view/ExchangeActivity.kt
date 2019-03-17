package com.teamsix.dnbxchange.view

import android.content.Context
import android.content.res.Resources
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.github.zawadz88.materialpopupmenu.popupMenu
import com.teamsix.dnbxchange.DataAccess
import com.teamsix.dnbxchange.R
import com.teamsix.dnbxchange.model.SharedValue
import kotlinx.android.synthetic.main.activity_exchange.*
import java.math.BigDecimal


class ExchangeActivity : FragmentActivity() {
    lateinit var host: NavHostFragment
    var toCurrency: String = "NOK"
    lateinit var fromCurrency: String
    lateinit var value: BigDecimal
    private lateinit var sharedValue: SharedValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)
        host = supportFragmentManager
            .findFragmentById(R.id.container) as NavHostFragment? ?: return
        sharedValue = DataAccess.sharedValue
        sharedValue.number.observe(host, Observer {
            value = it
            updateValue()
        })
        bottomNav.setupWithNavController(host.navController)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        initXchange(this, progress).execute()
    }

    fun changeCurrency(v: View) {
        val currencies = DataAccess.originalCurrencies
        val popupMenu = popupMenu {
            section {
                title = "Currencies"
                for (i in 0 until currencies.size) {
                    item {
                        icon = getResource(currencies[i].toLowerCase(), applicationContext)
                        label = currencies[i]
                        callback = {
                            if (v.id == R.id.imgFrom) {
                                fromCurrency = currencies[i]
                            }
                            if (v.id == R.id.imgTo) {
                                toCurrency = currencies[i]
                            }
                            updateValue()
                            v.background = getDrawable(getResource(currencies[i].toLowerCase(), applicationContext))
                        }
                    }

                }

            }
        }
        popupMenu.show(this, v)
    }

    fun getResource(name: String, context: Context): Int {
        val resource: Resources = context.resources
        return resource.getIdentifier(name, "drawable", context.packageName)
    }

    fun updateValue() {
        txtConvertedValue.text = "${value.toEngineeringString()} $toCurrency"
    }

    class initXchange(val context: Context, private val progressBar: ProgressBar) : AsyncTask<Void, Void, Int>() {
        override fun onPreExecute() {
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: Void?): Int? {
            val result: Int?

            result = try {
                DataAccess.initCoCur(context)
                DataAccess.initCountries(context)
                1
            } catch (e: Exception) {
                0
            }
            return result
        }

        override fun onPostExecute(result: Int?) {
            if (result == 1) {
                progressBar.visibility = View.GONE
            } else {
                Toast.makeText(context, "Loading error", Toast.LENGTH_SHORT).show()
            }

        }

    }
}

