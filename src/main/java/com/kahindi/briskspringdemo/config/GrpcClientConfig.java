package com.kahindi.briskspringdemo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for GRPC client.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@ConfigurationProperties(prefix = "grpc.client.server") /*the prefix for configuration in properties file*/
public record GrpcClientConfig(

        String host, /*the server address */
        int port /*the server port*/
) {
}
