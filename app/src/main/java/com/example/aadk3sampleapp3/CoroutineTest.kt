package com.example.aadk3sampleapp3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.aadk3sampleapp3.databinding.ActivityCoroutineTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineTest : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoroutineTestBinding.inflate(layoutInflater)
    }

    private lateinit var text: MutableLiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        text.observe(this) {
            binding.tv.text = text.value
        }

        // W^R -> Either Read or Write - But not both at the same time
/*
        val l = (1..10).toMutableList()
        var i = 0
        while (i < l.size) {
            val it = l[i]
            if (it % 2 == 0) {
                l.remove(it)
            }
            i+=1
        }
*/

        // Coroutines
        // ThreadPool -> 10 operations || we have to create 10 different threads
        // LightWeight -> We can run multiple Coroutines in a single thread
        // Same coroutine can switch contexts (Jump from an IO Thread to the Main Thread)
        // IO Thread -> 1 CR (Network Call) | 2 CR (Fetch this data and push it to Database) | 3 CR (Complex Calculation)

//        BEST WAY TO RUN A BACKGROUND AS WELL AS A FOREGROUND PROCESS ONE BY ONE
        lifecycleScope.launch(Dispatchers.IO) {
            // Network Call
            // Database Call
            withContext(Dispatchers.Main) {
                // Update UI
            }
        }

        // Attached with the Current Activities Lifecycle
        lifecycleScope.launch {
            // Write my coroutine definition in here
            // Infinite Loop
            while (true) {
                Log.d("jedbv", "Infinite Loop")
            }
        }


        // This gave an error -> UI can not be accessed from a different thread
        /*
        NOT THE CORRECT WAY
        // Creating a UI
        thread {
            // Network functions (2 sec to respond) -- Background Thread
        }
        // UpdateUI -- Main Thread once the Network call is complete
        */

        /*
        THIS IS THE CORRECT WAY (NOT THE BEST)
        // Creating a UI
        thread {
            // Network functions (2 sec to respond) -- Background Thread
            runOnUiThread {
                // UpdateUI -- Main Thread once the Network call is complete
            }
        }
        */

        // We can not call a suspend function from anywhere outside of the Scope of a Coroutine or another Suspend Function
//        fetchString()
//        fetchDigit()

        GlobalScope.launch(Dispatchers.IO) {
            // StartTime = currentTime
            val x = async { fetchString() }
            val y = async { fetchDigit() }
            text.value = x.await()
            // EndTime = currentTime
            // EndTime - StartTime = 3
        }
    }

    private suspend fun fetchString(): String {
        delay(2000L)
        return "Sample String"
    }

    private suspend fun fetchDigit(): Int {
        delay(3000L)
        return 0
    }
}

// Threads are used for small processes that are to be executed in the Background
// For Eg -> Network Call, A database call -> An Image/Audio Download, Complex Calculation, etc.

// Long running processes that you would want them to be running in the background -> Services (Background Services / Foreground Services)
// For Eg -> Observe the location of a user, Downloading of a big file video
// If your service is idle or running for a long time. It tries to kill it and free up th memory

// Foreground Service -> Background Service that is Attached to a UI element -> Background Playback
// Notification / Bubbles / Dialogs / PictureInPicture

/*
Threads -> Chunks of Processes

|-> Thread for Operation 1
|| -> Thread for Operation 2

Multi-Threading

main - UI Thread -> Responsible for all the UI related things (rendering and registering user inputs)
We are not supposed to block this thread at all

thread03125 - IO Thread -> Input-Output -> Anything related to data (Network Call, Database call)

ThreadPool
. . . . (.) -> Thread
. . . . .
. . . . .

Zoom into a thread -> (One single thread)
------------(-) -> Coroutine
* */

// M-V-VM
/*
Model - View - ViewModel

SRP -> Single Responsibility Principle

UI -> View
Data -> Model
Logic / Calculation / etc -> VM -> Fetches a list

Testing -> Mock Data easily and you do noy need to worry much about the dependencies
*/
// Lifecycle Aware Components -> That updates itself according to the changes in the lifecycle of an Activity
// LiveData
