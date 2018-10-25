package com.example.dagger.workerdi.work

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import java.util.Random

@AutoFactory(implementing = [ListenableWorkerFactory::class])
class HelloWorker(
    context: Context,
    workerParams: WorkerParameters,
    @Provided private val random: Random
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val who = inputData.getString("who")
        Log.d(LOG_TAG, "Hello, $who")

        return if (random.nextInt(10) >= 6) {
            Result.SUCCESS
        } else {
            Result.RETRY
        }
    }

    companion object {
        private const val LOG_TAG = "HelloWorker"

        fun newInputData(who: String): Data = Data.Builder()
                .putString("who", who)
                .build()
    }
}
