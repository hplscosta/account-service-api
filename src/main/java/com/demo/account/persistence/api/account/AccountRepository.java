package com.demo.account.persistence.api.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Account repository interface to interact with persistence layer <br>
 * Extends {@link MongoRepository} interface.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	/**
	 * Find account by user.
	 *
	 * @param user
	 * @return {@link Optional} {@link Account}
	 */
	Optional<Account> findAccountByUser( String user );
}
