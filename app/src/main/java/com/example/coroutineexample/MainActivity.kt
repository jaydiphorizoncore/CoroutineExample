package com.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            //task1()
            printFollowers()

        }
        /*    CoroutineScope(Dispatchers.Main).launch {
                task2()
            }*/
    }

    private suspend fun printFollowers() {
        var followers = 0
       val job =  CoroutineScope(Dispatchers.IO).launch {
            followers = getFollowers()
        }
        Log.d("TAG", "printFollowers: $followers ")
        job.join()
        Log.d("TAG", "printFollowers: $followers ")

    }

    private suspend fun getFollowers(): Int {
        delay(2000)
        return 50
    }

    /*        suspend fun task1() {
                Log.d("TAG", "start task1")
                yield()
               // delay(2000)
                Log.d("TAG", "end task1")
            }

            suspend fun task2() {
                Log.d("TAG", "start task2")
                yield()
                Log.d("TAG", "end task2")
            }*/

}