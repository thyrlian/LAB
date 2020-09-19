package com.basgeekball.horoscopeservice

import java.time.MonthDay

enum class ZodiacSign {
    Capricorn {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(12, 22), MonthDay.of(1, 20))
        }
    },
    Aquarius {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(1, 21), MonthDay.of(2, 18))
        }
    },
    Pisces {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(2, 19), MonthDay.of(3, 20))
        }
    },
    Aries {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(3, 21), MonthDay.of(4, 20))
        }
    },
    Taurus {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(4, 21), MonthDay.of(5, 21))
        }
    },
    Gemini {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(5, 22), MonthDay.of(6, 21))
        }
    },
    Cancer {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(6, 22), MonthDay.of(7, 22))
        }
    },
    Leo {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(7, 23), MonthDay.of(8, 23))
        }
    },
    Virgo {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(8, 24), MonthDay.of(9, 22))
        }
    },
    Libra {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(9, 23), MonthDay.of(10, 23))
        }
    },
    Scorpio {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(10, 24), MonthDay.of(11, 22))
        }
    },
    Sagittarius {
        override fun matches(date: MonthDay): Boolean {
            return isInsideRange(date, MonthDay.of(11, 23), MonthDay.of(12, 21))
        }
    };

    abstract fun matches(date: MonthDay): Boolean

    protected fun isInsideRange(date: MonthDay, startDate: MonthDay, endDate: MonthDay): Boolean {
        return if (startDate.isBefore(endDate)) {
            date.isAfter(startDate) && date.isBefore(endDate) || date.equals(startDate) || date.equals(endDate)
        } else {
            date.isAfter(startDate) || date.isBefore(endDate) || date.equals(startDate) || date.equals(endDate)
        }
    }
}