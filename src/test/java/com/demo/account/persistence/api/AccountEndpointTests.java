package com.demo.account.persistence.api;

import com.demo.account.persistence.api.account.AccountService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup( this.context ).build();
	}
}
