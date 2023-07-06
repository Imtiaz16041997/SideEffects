package com.imtiaz.sideeffect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LaunchEffectsExample(fakeViewModel: FakeViewModel){
    val state = fakeViewModel.state.value

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
               Text(text = "Success")
            }
        }
        is ResultType.Idle -> {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Idle")
            }
        }
    }
}