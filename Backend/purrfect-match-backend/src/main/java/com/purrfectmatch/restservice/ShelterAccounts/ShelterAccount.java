package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class ShelterAccount {

	private @Id @GeneratedValue Long id;
	private String email;
	private String passwordHash;
	private String passwordSalt;
	private String shelterName;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	private String phoneNumber;
	private String website;

	ShelterAccount() {
	}

	ShelterAccount(String email, String shelterName) {
		this.email = email;
		this.shelterName = shelterName;
	}

	ShelterAccount(String email, String passwordHash, String passwordSalt, String shelterName, String street, String city,
			String state, int zipCode, String phoneNumber, String website) {
		this.email = email;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
		this.shelterName = shelterName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.website = website;
	}
}