package com.demo.account.service.api.account;

import com.demo.account.service.api.config.MongoConfigTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing {@link AccountRepository}. <br>
 * This test has a {@link MongoRepository} dependency.<br>
 * Uses Spring Context.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@RunWith( SpringRunner.class )
@SpringBootTest( classes = MongoConfigTests.class )
public class AccountRepositoryTests {

	@Autowired
	private AccountRepository repository;

	/**
	 * Insert a new account in repository<br>
	 * Positive test.
	 */
	@Test
	@DirtiesContext
	public void valid_insert_new_account() {

		// given
		Account account = new Account( "user", "name" );

		// when
		Account accountInserted = repository.insert( account );

		// then
		assertThat( account ).isEqualToComparingFieldByField( accountInserted );
	}

	/**
	 * Find account by user in repository<br>
	 * Positive test.
	 */
	@Test
	@DirtiesContext
	public void valid_find_account_by_user() {

		// given
		Account account = new Account( "user", "name" );
		repository.insert( account );

		// when
		Optional<Account> accountLocated = repository.findAccountByUser( "user" );

		// then
		assertThat( accountLocated.isPresent() ).isTrue();
		assertThat( account ).isEqualToComparingFieldByField( accountLocated.get() );
	}

	/**
	 * Returns an Optional object empty when no account is found in repository<br>
	 * Positive test.
	 */
	@Test
	@DirtiesContext
	public void valid_find_account_by_user_missing() {

		// when
		Optional<Account> accountLocated = repository.findAccountByUser( "user" );

		// then
		assertThat( accountLocated.isPresent() ).isFalse();
	}

	/**
	 * Find all accounts in repository<br>
	 * Positive test.
	 */
	@Test
	@DirtiesContext
	public void valid_findAll_accounts() {

		// given
		Account account1 = new Account( "user1", "name1" );
		Account account2 = new Account( "user2", "name2" );
		Account account3 = new Account( "user3", "name3" );
		repository.insert( Arrays.asList( account1, account2, account3 ) );

		// when
		List<Account> accounts = repository.findAll();

		// then
		assertThat( accounts ).hasSize( 3 ).contains( account1, account2, account3 );
	}

	/**
	 * Insert a duplicate account<br>
	 * Negative test.
	 */
	@Test( expected = DuplicateKeyException.class )
	@DirtiesContext
	public void invalid_duplicate_account() {

		// given
		Account account1 = new Account( "user1", "name1" );
		Account account2 = new Account( "user1", "name2" );

		// when
		repository.insert( Arrays.asList( account1, account2 ) );
	}
}
