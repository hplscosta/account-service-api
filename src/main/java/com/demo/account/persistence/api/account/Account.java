package com.demo.account.persistence.api.account;

import com.demo.account.persistence.api.account.address.Address;
import lombok.Value;

/**
 * Account entity.
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Value
public class Account {

	String name;

	Integer age;

	Address address;
}
