package com.nutrisports.`shared`.domain

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val city: String? = null,
    val postalCode: Int? = null,
    val address: String? = null,
    val phone: PhoneNumber? = null,
    val cart: List<CartItem> = emptyList()
)

@Serializable
data class PhoneNumber(
    val dialCode: Int,
    val number: String,
)