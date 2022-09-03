package com.bonespirito.springbootrestcompress.infrastructure.resource.configuration

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.HandlerCollection
import org.eclipse.jetty.server.handler.gzip.GzipHandler
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configure Jetty web server so it handles compressed requests.
 */
@Configuration
class JettyWebServerConfiguration {
    /**
     * Customise the Jetty web server to automatically decompress requests.
     */
    @Bean
    fun jettyServletWebServerFactory(): JettyServletWebServerFactory {
        val factory = JettyServletWebServerFactory()
        factory.addServerCustomizers(
            JettyServerCustomizer { server: Server ->
                val gzipHandler = GzipHandler()
                // Enable request decompression
                gzipHandler.inflateBufferSize = MIN_BYTES
                gzipHandler.handler = server.handler
                val handlerCollection = HandlerCollection(gzipHandler)
                server.handler = handlerCollection
            }
        )
        return factory
    }

    companion object {
        private const val MIN_BYTES = 1
    }
}
