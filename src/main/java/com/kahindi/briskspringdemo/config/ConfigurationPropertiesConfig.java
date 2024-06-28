package com.kahindi.briskspringdemo.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The {@code ConfigurationPropertiesConfig} class is responsible for enabling the configuration properties
 * specified in the properties file.
 *
 * <p>The class is annotated with {@code @EnableConfigurationProperties} to enable the configuration properties
 * for the specified classes.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     {@code @EnableConfigurationProperties}
 *     {@code @ConfigurationPropertiesConfig}
 *     public class Application {
 *         // Application code...
 *     }
 * </pre>
 *
 * <p>Note that the example usage shows the annotation placed on a hypothetical {@code Application} class,
 * but it can be placed on any class within the application.</p>
 *
 * @see EnableConfigurationProperties
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 *
 */

@Configuration
@EnableConfigurationProperties( /*enable configuration props in the properties file*/
        value = {
                GrpcClientConfig.class /*for grpc client */
        }
)
public class ConfigurationPropertiesConfig {
}
