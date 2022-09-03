package com.bonespirito.springbootrestcompress.infrastructure.resource.interceptors

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import java.io.IOException

class LengthInterceptor : ClientHttpRequestInterceptor {

    private val LOG: Logger = LoggerFactory.getLogger(LengthInterceptor::class.java)

    @Throws(IOException::class)
    override fun intercept(
        request: org.springframework.http.HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        val response: ClientHttpResponse = execution.execute(request, body)
        val length: Long = response.headers.contentLength

        LOG.info("\n\n Payload size: $length bytes\n")

        return response
    }
}
