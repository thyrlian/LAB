package com.basgeekball.horoscopeservice.model

import java.time.MonthDay

enum class ZodiacSign {
    Capricorn {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(12, 22), MonthDay.of(1, 20))
        }

        override fun symbol(): String {
            return "♑"
        }
    },
    Aquarius {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(1, 21), MonthDay.of(2, 18))
        }

        override fun symbol(): String {
            return "♒"
        }
    },
    Pisces {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(2, 19), MonthDay.of(3, 20))
        }

        override fun symbol(): String {
            return "♓"
        }
    },
    Aries {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(3, 21), MonthDay.of(4, 20))
        }

        override fun symbol(): String {
            return "♈"
        }
    },
    Taurus {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(4, 21), MonthDay.of(5, 21))
        }

        override fun symbol(): String {
            return "♉"
        }
    },
    Gemini {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(5, 22), MonthDay.of(6, 21))
        }

        override fun symbol(): String {
            return "♊"
        }
    },
    Cancer {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(6, 22), MonthDay.of(7, 22))
        }

        override fun symbol(): String {
            return "♋"
        }
    },
    Leo {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(7, 23), MonthDay.of(8, 23))
        }

        override fun symbol(): String {
            return "♌"
        }
    },
    Virgo {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(8, 24), MonthDay.of(9, 22))
        }

        override fun symbol(): String {
            return "♍"
        }
    },
    Libra {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(9, 23), MonthDay.of(10, 23))
        }

        override fun symbol(): String {
            return "♎"
        }
    },
    Scorpio {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(10, 24), MonthDay.of(11, 22))
        }

        override fun symbol(): String {
            return "♏"
        }
    },
    Sagittarius {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(11, 23), MonthDay.of(12, 21))
        }

        override fun symbol(): String {
            return "♐"
        }
    };

    abstract fun matches(date: MonthDay): Boolean

    abstract fun symbol(): String

    protected fun isInsideRange(date: MonthDay, startDate: MonthDay, endDate: MonthDay): Boolean {
        return if (startDate.isBefore(endDate)) {
            date.isAfter(startDate) && date.isBefore(endDate) || date.equals(startDate) || date.equals(endDate)
        } else {
            date.isAfter(startDate) || date.isBefore(endDate) || date.equals(startDate) || date.equals(endDate)
        }
    }
}