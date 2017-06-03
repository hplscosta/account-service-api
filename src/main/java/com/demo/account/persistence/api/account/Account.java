package com.demo.account.persistence.api.account;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Account entity.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Document( collection = "accounts" )
@Getter
@EqualsAndHashCode( of = "user" )
@RequiredArgsConstructor( access = AccessLevel.PACKAGE )
public class Account {

	@Id
	private final String user;

	private final String name;

	@Setter
	private Integer age;

	@Setter
	private Address address;
}
