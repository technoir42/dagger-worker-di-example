package com.example.dagger.workerdi.inject

import androidx.work.WorkerFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun workerFactory(): WorkerFactory
}
