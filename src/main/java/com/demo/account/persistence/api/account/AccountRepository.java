package com.demo.account.persistence.api.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Account repository interface to interact with persistence layer <br>
 * Extends {@link MongoRepository} interface.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}
