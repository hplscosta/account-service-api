package com.demo.account.persistence.api.account.exception;

import lombok.Getter;

/**
 * Exception retrieved when no account is found.<br>
 * Extends {@link RuntimeException}.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Getter
public class AccountNotFoundException extends RuntimeException {

	private final String user;

	public AccountNotFoundException( String user ) {
		super( "Account not found. User: " + user );
		this.user = user;
	}
}
