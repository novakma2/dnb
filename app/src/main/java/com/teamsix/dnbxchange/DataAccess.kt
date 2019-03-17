package com.teamsix.dnbxchange

import android.content.Context
import android.telephony.TelephonyManager
import androidx.lifecycle.ViewModelProvider
import com.teamsix.dnbxchange.model.SharedValue

object DataAccess {
    lateinit var originalCurrencies: MutableList<String>
    lateinit var coCur: MutableList<String>
    val sharedValue: SharedValue = ViewModelProvider.NewInstanceFactory().create(SharedValue::class.java)
    lateinit var countryCodeValue: String
    fun initCoCur(context: Context) {
        val arrayOfCountries = context.resources.getStringArray(R.array.countryCodes)
        val arrayOfCurrencies = context.resources.getStringArray(R.array.currencies)
        var newList: MutableList<String> = emptyList<String>().toMutableList()
        for (i in (0 until arrayOfCountries.size)) {
            newList.add(arrayOfCountries[i])
            newList.add(arrayOfCurrencies[i])
        }
        coCur = newList
    }

    fun getCountryCode(context: Context): String {
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        countryCodeValue = tm.networkCountryIso
        return countryCodeValue
    }

    fun initCountries(context: Context) {
        var initedCurrencies: MutableList<String> = emptyList<String>().toMutableList()
        val arrayOfCurrencies = context.resources.getStringArray(R.array.currencies)
        for (i in (0 until arrayOfCurrencies.size)) {
            if (!initedCurrencies.contains(arrayOfCurrencies[i])) {
                initedCurrencies.add(arrayOfCurrencies[i])
            }
        }
        initedCurrencies.sort()
        originalCurrencies = initedCurrencies
    }
}