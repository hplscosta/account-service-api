package com.demo.account.persistence.api.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

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
	 * Insert a new account in repository<br>
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

}
