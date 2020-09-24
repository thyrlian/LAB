package com.basgeekball.horoscopeservice

import com.basgeekball.horoscopeservice.model.ZodiacSign
import java.time.MonthDay
import java.util.*

class Horoscope {
    companion object {
        fun tellZodiacSign(dob: Date): ZodiacSign? {
            val calendar = Calendar.getInstance()
            calendar.time = dob
            val date = MonthDay.of(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
            ZodiacSign.values().forEach {
                if (it.matches(date)) return it
            }
            return null
        }
    }
}