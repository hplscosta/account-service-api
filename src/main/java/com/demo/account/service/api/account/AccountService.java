package com.demo.account.service.api.account;

import com.demo.account.service.api.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * Account service to validate accounts and interacts with persistence layer. <br>
 * Interacts with {@link AccountRepository}.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository repository;

	/**
	 * Validates mandatory properties and calls {@link AccountRepository} to save account.
	 *
	 * @param {@link Account}
	 * @return a new {@link Account}
	 */
	public Account insert( Account account ) {
		Assert.hasText( account.getUser(), "User cannot be empty." );
		Assert.hasText( account.getName(), "Name cannot be empty." );
		log.info( "Inserting user {} with name {}", account.getUser(), account.getName() );
		return repository.insert( account );
	}

	/**
	 * Calls {@link AccountRepository} to find {@link Account} by user.
	 *
	 * @param user
	 * @return {@link Account}
	 */
	public Account find( String user ) {
		Assert.hasText( user, "User cannot be empty." );
		log.info( "Looking for user {}", user );
		Optional<Account> account = repository.findAccountByUser( user );
		return account.orElseThrow( () -> new AccountNotFoundException( user ) );
	}

	/**
	 * Calls {@link AccountRepository} to find all {@link Account} in repository.
	 *
	 * @return a list of {@link Account}
	 */
	public List<Account> findAll() {
		log.info( "Getting all users" );
		return repository.findAll();
	}
}
