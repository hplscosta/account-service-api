package com.demo.account.service.api.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Import {@link MongoConfig} to enable Mongo repositories <br>
 * Enable auto configuration to initialize a Embedded Mongo instance.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Configuration
@EnableAutoConfiguration
@Import( MongoConfig.class )
public class MongoConfigTests {

}
