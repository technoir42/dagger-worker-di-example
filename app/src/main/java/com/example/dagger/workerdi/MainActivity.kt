package com.example.dagger.workerdi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.dagger.workerdi.work.HelloWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_do_work)
        button.setOnClickListener { scheduleWork() }
    }

    private fun scheduleWork() {
        WorkManager.getInstance().enqueue(OneTimeWorkRequestBuilder<HelloWorker>()
                .setInputData(HelloWorker.newInputData("world"))
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                .build())
    }
}
