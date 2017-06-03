package com.demo.account.persistence.api.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Testing {@link AccountRepository}. <br>
 * This test has a {@link MongoRepository} dependency.<br>
 * Uses Spring Context.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@RunWith( SpringRunner.class )
public class AccountRepositoryTests {

	/**
	 * Insert a new account in repository<br>
	 * Positive test.
	 */
	@Test
	public void valid_insert_new_account() {

	}

	/**
	 * Find account in repository<br>
	 * Positive test.
	 */
	@Test
	public void valid_find_account() {

	}

	/**
	 * Find all accounts in repository<br>
	 * Positive test.
	 */
	@Test
	public void valid_findAll_accounts() {

	}

	/**
	 * Insert a duplicate account<br>
	 * Negative test.
	 */
	@Test
	public void invalid_duplicate_account() {

	}
}
