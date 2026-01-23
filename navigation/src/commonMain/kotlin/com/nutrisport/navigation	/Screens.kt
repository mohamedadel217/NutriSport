package com.nutrisport.`navigation`

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object Auth : Screens()
}