package com.demo.account.persistence.api.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

	private final AccountService service;

	@GetMapping( path = "/{user}" )
	public ResponseEntity<Account> get( @PathVariable String user ) {
		return ResponseEntity.ok( service.find( user ) );
	}

	@GetMapping
	public ResponseEntity<List<Account>> get() {
		return ResponseEntity.ok( service.findAll() );
	}
}
