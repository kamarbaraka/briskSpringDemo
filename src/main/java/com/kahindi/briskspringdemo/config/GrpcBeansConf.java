package com.kahindi.briskspringdemo.config;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The {@code GrpcBeansConf} class is a configuration class that provides beans for gRPC communication.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Configuration
@RequiredArgsConstructor
public class GrpcBeansConf {

    /**
     * Configuration properties for GRPC client.
     */
    private final GrpcClientConfig grpcClientConfig;

    /**
     * Returns a managed gRPC channel.
     *
     * This method creates a managed channel for gRPC communication. The channel is configured based on the values provided in the {@link GrpcClientConfig} object, which contains
     *  the server address and port.
     *
     * @return a managed {@link ManagedChannel} object
     * @see ManagedChannelBuilder
     * @see GrpcClientConfig
     */
    @Bean
    public ManagedChannel managedChannel() {

        /*configure tne bean*/
        return ManagedChannelBuilder.forAddress(grpcClientConfig.host(), grpcClientConfig.port())
                .usePlaintext()
                .build();
    }
}