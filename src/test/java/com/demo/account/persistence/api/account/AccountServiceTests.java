package com.demo.account.persistence.api.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * Testing {@link AccountService} methods. <br>
 * Mocks {@link AccountRepository}.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@RunWith( BlockJUnit4ClassRunner.class )
public class AccountServiceTests {

	private AccountService service;

	private AccountRepository repository;

	@Before
	public void setUp() throws Exception {
		repository = mock( AccountRepository.class );
		service = new AccountService( repository );
	}

	/**
	 * Calling service to insert a valid account.<br>
	 * Positive test.
	 */
	@Test
	public void valid_insert_new_account() {

		// given
		Account account = new Account( "user", "name" );
		given( repository.insert( account ) ).willReturn( account );

		// when
		Account inserted = service.insert( account );

		// then
		then( repository ).should().insert( account );
		assertThat( inserted ).isEqualToComparingFieldByField( account );
	}

	/**
	 * Calling service to insert an invalid account. Missing user.<br>
	 * Negative test.
	 */
	@Test( expected = IllegalArgumentException.class )
	public void invalid_insert_account_missing_user() {

		// given
		Account account = new Account( null, "name" );

		// when
		service.insert( account );
	}

	/**
	 * Calling service to insert an invalid account. Missing name.<br>
	 * Negative test.
	 */
	@Test( expected = IllegalArgumentException.class )
	public void invalid_insert_account_missing_name() {

		// given
		Account account = new Account( "user", null );

		// when
		service.insert( account );
	}

	/**
	 * Calling service to find an account.<br>
	 * Positive test.
	 */
	@Test
	public void valid_find_account() {

		// given
		Account account = new Account( "user", "name" );
		given( repository.findOne( account.getUser() ) ).willReturn( account );

		// when
		Account accountLocated = service.find( account.getUser() );

		// then
		then( repository ).should().findOne( account.getUser() );
		assertThat( accountLocated ).isEqualToComparingFieldByField( account );
	}

	/**
	 * Calling service to find all accounts.<br>
	 * Positive test.
	 */
	@Test
	public void valid_find_all_account() {

		// given
		Account account1 = new Account( "user1", "name1" );
		Account account2 = new Account( "user2", "name2" );
		Account account3 = new Account( "user3", "name3" );
		given( repository.findAll() ).willReturn( Arrays.asList( account1, account2, account3 ) );

		// when
		List<Account> accounts = service.findAll();

		// then
		then( repository ).should().findAll();
		assertThat( accounts ).contains( account1, account2, account3 );
	}
}
