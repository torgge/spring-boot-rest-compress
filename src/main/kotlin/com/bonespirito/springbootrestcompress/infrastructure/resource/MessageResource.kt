package com.bonespirito.springbootrestcompress.infrastructure.resource

import com.bonespirito.springbootrestcompress.domain.message.MessageDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageResource {
    /**
     * A simple endpoint that responds with "Processed " + supplied Message content.
     *
     * @param headers
     * @param message
     * @return
     */
    @PostMapping(value = [REQUEST_MAPPING])
    fun processMessage(
        @RequestHeader headers: Map<String, String>,
        @RequestBody message: MessageDTO
    ): ResponseEntity<String> {
        // Print headers
        headers.forEach { (k: String, v: String) ->
            LOG.info(
                "$k=$v"
            )
        }

        return ResponseEntity.ok(PROCESSED + message.text)
    }

    companion object {
        protected const val PROCESSED = "Processed "
        protected const val REQUEST_MAPPING = "process"
        private val LOG: Logger = LoggerFactory.getLogger(MessageResource::class.java)
    }
}
