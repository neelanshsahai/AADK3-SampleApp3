package com.example.aadk3sampleapp3.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.aadk3sampleapp3.model.Person

class PaymentsViewModel {
    // Every Business Logic associated with Payments
    lateinit var isPaymentDone: MutableLiveData<Boolean>

    fun checkPayments() {
        isPaymentDone.value = true
        // Create an Interface
        // Invoke a callback
    }

    private fun getPaymentsStatus(): Boolean {
        // Do an API Call
        return true
    }
}


// interface ApiService {
//     fun fetchStudents() : Flow<List<Person>>
// }

// Flows are used a lot with Coroutines, Room, Retrofit, specifically Compose

// State Hoisting -> val state by remember { false }
// state = true
// Composable went under recomposition

// Clean Architecture ->
/*
Dependency Injections -> Hilt, Dagger2, Koin
ViewModels
LiveData
Coroutines
Abstraction
Room / Retrofit / (Jetpack Libraries)
Usecases / Repositories
 */
