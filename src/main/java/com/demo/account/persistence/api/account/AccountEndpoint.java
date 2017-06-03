package com.demo.account.persistence.api.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

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

	@PostMapping
	public ResponseEntity<Account> create( @RequestBody Account account ) {
		Account inserted = service.insert( account );
		return ResponseEntity.created( createLocation( inserted.getUser() ) ).body( account );
	}

	private URI createLocation( String id ) {
		return URI.create( linkTo( AccountEndpoint.class ).slash( id ).withSelfRel().getHref() );
	}
}
