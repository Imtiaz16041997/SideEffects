package com.imtiaz.sideeffect

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


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

//var i:Int = 0
//@Composable
//fun SideEffects(){
//    SideEffect {
//        i++
//    }
//
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//        Text(text = "Side Effects")
//    }
//}