package com.demo.account.persistence.api.account;

import lombok.*;

/**
 * Account entity.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Getter
@EqualsAndHashCode( of = "user" )
@RequiredArgsConstructor( access = AccessLevel.PACKAGE )
public class Account {

	@NonNull
	private final String user;

	@NonNull
	private final String name;

	@Setter
	private Integer age;

	@Setter
	private Address address;
}
