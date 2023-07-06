package com.imtiaz.sideeffect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@Composable
fun LaunchEffectsExample(fakeViewModel: FakeViewModel){
    val state = fakeViewModel.state.value

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit,  block = {
        fakeViewModel.getData()
    })


    when(state){
        is ResultType.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }

        }
        is ResultType.Success -> {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
               Button(onClick = {
                   val  job = scope.launch {
                       fakeViewModel.getData()
                   }
                   job.cancel()
                   scope.cancel()
               }) {

               }
            }
        }
        is ResultType.Idle -> {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Idle")
            }
        }
    }
}