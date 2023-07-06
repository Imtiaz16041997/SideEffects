package com.imtiaz.sideeffect

sealed class ResultType {
    object Success:ResultType()
    object Loading:ResultType()
    object Idle:ResultType()
}