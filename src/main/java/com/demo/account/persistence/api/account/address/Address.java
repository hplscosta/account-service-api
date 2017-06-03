package com.demo.account.persistence.api.account.address;

import lombok.Value;

/**
 * Address value object
 *
 * @author Hugo Costa
 * @since 1.0.0
 */
@Value
public class Address {

	String city;

	String country;
}
