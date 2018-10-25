package com.example.dagger.workerdi.inject

import androidx.work.WorkerFactory
import com.example.dagger.workerdi.work.AppWorkerFactory
import com.example.dagger.workerdi.work.HelloWorker
import com.example.dagger.workerdi.work.HelloWorkerFactory
import com.example.dagger.workerdi.work.ListenableWorkerFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {
    @Binds
    fun bindWorkerFactory(impl: AppWorkerFactory): WorkerFactory

    @Binds
    @IntoMap
    @ClassKey(HelloWorker::class)
    fun bindHelloWorkerFactory(impl: HelloWorkerFactory): ListenableWorkerFactory
}
