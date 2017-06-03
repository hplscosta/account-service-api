package com.demo.account.persistence.api.config;

import com.demo.account.persistence.api.account.AccountRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Mongo configuration <br>
 * Enable Mongo Repositories.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Configuration
@EnableMongoRepositories( basePackageClasses = AccountRepository.class )
public class MongoConfig {

}
