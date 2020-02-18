package com.eunhye.dabang_test

import android.app.Application
import com.eunhye.dabang_test.di.viewModelModule
import org.koin.android.ext.android.startKoin

class DabangTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(listOf(
            viewModelModule
        ))
    }

}