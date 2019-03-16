package com.teamsix.dnbxchange.model

import java.math.BigDecimal
import java.util.*

data class CurrencyRate(
    val currency: String,
    val baseCurrency: String,
    val buyRate: BigDecimal,
    val country: String,
    val updateDate: Date
)