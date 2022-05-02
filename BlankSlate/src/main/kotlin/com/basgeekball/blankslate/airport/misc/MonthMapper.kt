package com.basgeekball.blankslate.airport.misc

import java.time.Month
import java.time.format.TextStyle
import java.util.*

class MonthMapper {
    companion object {
        val MONTHS_LIST = generateMonthsList()

        private fun generateMonthsList(): HashMap<String,Month> {
            val list = HashMap<String,Month>()
            for (idx in 1..12) {
                val month = Month.of(idx)
                list[month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).uppercase()] = month
            }
            return list
        }

        fun map(month: String): Month? {
            return MONTHS_LIST[month.uppercase()]
        }
    }
}