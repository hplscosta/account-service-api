package com.demo.account.persistence.api.account;

import com.demo.account.persistence.api.account.exception.AccountEndpointAdvice.ErrorMessage;
import com.demo.account.persistence.api.account.exception.AccountNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing {@link AccountEndpoint} methods. <br>
 * Mocks {@link AccountService}. <br>
 * Spring MVC test.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@RunWith( SpringRunner.class )
@WebMvcTest( AccountEndpoint.class )
public class AccountEndpointTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@MockBean
	private AccountService service;

	private ObjectMapper mapper;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup( this.context ).build();
		mapper = new ObjectMapper();
	}

	/**
	 * Calling endpoint to get account.<br>
	 * Positive test.
	 */
	@Test
	public void valid_get_account() throws Exception {

		// given
		Account account = new Account( "user", "name" );
		given( service.find( account.getUser() ) ).willReturn( account );

		// when
		//@formatter:off
		MvcResult result = this.mockMvc.perform( get( "/account/{user}", account.getUser() ).contentType( MediaType.APPLICATION_JSON ) )
			.andExpect( status().isOk() ).andReturn();
		//@formatter:on

		// then
		then( service ).should().find( account.getUser() );
		Account accountLocated = mapper.readValue( result.getResponse().getContentAsString(), Account.class );
		assertThat( accountLocated ).isEqualToComparingFieldByField( account );
	}

	/**
	 * Calling endpoint to get account. Account does not exist. Must return an error message.<br>
	 * Negative test.
	 */
	@Test
	public void invalid_get_account_missing() throws Exception {

		// given
		String user = "user";
		given( service.find( user ) ).willThrow( new AccountNotFoundException( user ) );

		// when
		//@formatter:off
		MvcResult result = this.mockMvc.perform( get( "/account/{user}", user ).contentType( MediaType.APPLICATION_JSON ) )
			.andExpect( status().isNotFound() ).andReturn();
		//@formatter:on

		// then
		then( service ).should().find( user );
		ErrorMessage errorMessage = mapper.readValue( result.getResponse().getContentAsString(), ErrorMessage.class );
		assertThat( errorMessage ).isEqualTo( new ErrorMessage( "Account not found. User: user" ) );
	}
}
