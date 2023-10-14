package com.example.samespacetask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp()
class SameSpaceApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpTimberForLogging()
    }

    private fun setUpTimberForLogging() {

        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String? {
                return "[SameSpaceTask][${super.createStackElementTag(element)}][${element.methodName}]:${element.lineNumber}"
            }
        })

    }
}