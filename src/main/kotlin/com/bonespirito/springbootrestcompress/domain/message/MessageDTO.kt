package com.bonespirito.springbootrestcompress.domain.message

import kotlinx.serialization.Serializable

@Serializable
data class MessageDTO(
    val text: String
)
