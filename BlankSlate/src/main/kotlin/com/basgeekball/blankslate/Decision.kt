package com.basgeekball.blankslate

enum class Decision(val idx: Int) {
    NO(0) {
        override fun evaluate() = false
    },
    YES(1) {
        override fun evaluate() = true
    };

    abstract fun evaluate(): Boolean

    companion object {
        fun getByValue(value: Int) = values().find { it.idx == value }
    }
}