package com.example.dagger.workerdi.inject

import dagger.Module
import dagger.Provides
import java.util.Random

@Module(includes = [WorkerModule::class])
object AppModule {
    @Provides
    @JvmStatic
    fun provideRandom(): Random = Random()
}
