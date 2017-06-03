package com.demo.account.persistence.api;

import com.demo.account.persistence.api.account.Account;
import com.demo.account.persistence.api.account.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account endpoint to access {@link Account} data. <br>
 * The {@link RestController} calls {@link AccountService} to insert new data or retrieve existing one.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping( path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
@RequiredArgsConstructor
public class AccountEndpoint {

	public final AccountService service;
}
