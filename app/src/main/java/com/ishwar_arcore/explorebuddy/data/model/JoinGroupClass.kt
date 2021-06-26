package com.ishwar_arcore.explorebuddy.data.model

import java.io.Serializable

data class JoinGroupClass(
    val place: String, val members: String, val vehicle: String
) : Serializable {
}