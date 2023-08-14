package ru.potemkin.dating.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import ru.potemkin.dating.R
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var swipeViewModel: SwipeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeViewModel = ViewModelProvider(this)[SwipeViewModel::class.java]
        swipeViewModel.userList.observe(this){
            Log.d("MainActivityTest",it.toString())
        }

    }
}