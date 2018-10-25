package com.example.dagger.workerdi

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.dagger.workerdi.inject.DaggerAppComponent

class ExampleApplication : Application() {
    private val component = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        initializeWorkManager()
    }

    private fun initializeWorkManager() {
        WorkManager.initialize(this, Configuration.Builder()
                .setWorkerFactory(component.workerFactory())
                .build())
    }
}
