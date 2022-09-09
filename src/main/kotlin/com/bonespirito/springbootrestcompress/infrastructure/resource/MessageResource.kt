package com.bonespirito.springbootrestcompress.infrastructure.resource

import com.bonespirito.springbootrestcompress.domain.message.MessageDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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
    ): ResponseEntity<MessageDTO> {
        // Print headers
//        headers.forEach { (k: String, v: String) ->
//            LOG.info(
//                "$k=$v"
//            )
//        }

        logger.info("-=PROCESSED=-")
        return ResponseEntity.ok(message)
    }

    @GetMapping(value = [REQUEST_MAPPING])
    fun get(): ResponseEntity<String> = ResponseEntity.ok(PROCESSED + BODY)

    companion object {
        protected const val PROCESSED = "Processed "
        protected const val REQUEST_MAPPING = "process"
        protected const val BODY = "03/22 08:53:38 TRACE  :......router_forward_getOI:         source address:   9.67.116.98" +
            "03/22 08:53:38 TRACE  :......router_forward_getOI:         out inf:   9.67.116.98" +
            "03/22 08:53:38 TRACE  :......router_forward_getOI:         out inf:   9.67.116.98" +
            "03/22 08:53:38 TRACE  :......router_forward_getOI:         out inf:   9.67.116.98" +
            "03/22 08:53:38 TRACE  :......router_forward_getOI:         out inf:   9.67.116.98"
        private val logger: Logger = LoggerFactory.getLogger(MessageResource::class.java)
    }
}
