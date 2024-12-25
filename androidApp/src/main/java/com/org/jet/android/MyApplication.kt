package com.org.jet.android

import android.app.Application
import com.org.jet.di.initKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}