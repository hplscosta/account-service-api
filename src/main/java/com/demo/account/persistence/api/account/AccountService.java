package com.demo.account.persistence.api.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

	public Account insert( Account account ) {
		Assert.hasText( account.getUser(), "User cannot be empty." );
		Assert.hasText( account.getName(), "Name cannot be empty." );
		log.info( "Inserting user {} with name {}", account.getUser(), account.getName() );
		return repository.insert( account );
	}
}
