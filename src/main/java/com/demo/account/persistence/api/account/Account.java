package com.demo.account.persistence.api.account;

import com.demo.account.persistence.api.account.address.Address;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

/**
 * Account entity.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Value
@EqualsAndHashCode( of = "user" )
public class Account {

	@NonNull
	String user;

	@NonNull
	String name;

	Integer age;

	Address address;
}
