package com.teamsix.dnbxchange

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.teamsix.dnbxchange.model.SharedValue

object DataAccess {
    val sharedValue: SharedValue = ViewModelProvider.NewInstanceFactory().create(SharedValue::class.java)
    fun getCoCur(context: Context): List<String> {
        val arrayOfCountries = context.resources.getStringArray(R.array.countryCodes)
        val arrayOfCurrencies = context.resources.getStringArray(R.array.currencies)
        var newList: MutableList<String> = emptyList<String>().toMutableList()
        for (i in 0..arrayOfCountries.size * 2) {
            newList.add(arrayOfCountries[i.div(2)])
            newList.add(arrayOfCurrencies[(i + 1).div(2)])
        }
        return newList
    }

}