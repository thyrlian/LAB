package com.basgeekball.userservice.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
    override fun getValue(thisRef: R, property: KProperty<*>): Logger = getLogger(getClass(thisRef.javaClass))

    private fun getLogger(klass: Class<*>): Logger = LoggerFactory.getLogger(klass)

    private inline fun <T: Any> getClass(klass: Class<T>): Class<*> {
        return klass.enclosingClass?.takeIf {
            it.kotlin.companionObject?.java == klass
        } ?: klass
    }
}