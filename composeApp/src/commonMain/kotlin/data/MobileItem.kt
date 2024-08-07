package org.pradip.cmp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MobileItem(
    @SerialName("id") val id: String,
    @SerialName("name")val name: String,
    @SerialName("data") val data: Map<String, String>?
)