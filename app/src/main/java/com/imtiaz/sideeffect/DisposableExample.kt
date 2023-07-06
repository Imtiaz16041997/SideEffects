package com.imtiaz.sideeffect

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect


@Composable
fun DisposableExample(activity: MainActivity,backPressedDispatcher: OnBackPressedDispatcher){
    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
           activity.finish()
        }
    }

    DisposableEffect(key1 = backPressedDispatcher){
        Log.d("TAG","DisposableExample: start")
        backPressedDispatcher.addCallback(callback)
        onDispose {
            Log.d("TAG","DisposableExample: onDispose")
            callback.remove()
        }
    }




}