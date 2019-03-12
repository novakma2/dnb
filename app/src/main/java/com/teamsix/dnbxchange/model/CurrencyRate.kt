package com.teamsix.dnbxchange.model

import java.util.*

data class CurrencyRate(val currency: String, val baseCurrency: String, val country: String, val updateDate: Date)