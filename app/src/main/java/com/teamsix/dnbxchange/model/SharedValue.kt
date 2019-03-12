package com.teamsix.dnbxchange.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

//https://medium.com/mindorks/how-to-communicate-between-fragments-and-activity-using-viewmodel-ca733233a51c
class SharedValue:ViewModel(){
    val number = MutableLiveData<BigDecimal>()
}