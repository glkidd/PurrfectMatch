package com.purrfectmatch.restservice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "shelter_accounts")
class ShelterAccount {
	@Column(name = "id")
	private @Id @GeneratedValue Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password_hash")
	private String passwordHash;
	@Column(name = "password_salt")
	private String passwordSalt;
	@Column(name = "shelter_name")
	private String shelterName;
	@Column(name = "city")
	private String city;
	@Column(name = "street")
	private String street;
	@Column(name = "state")
	private String state;
	@Column(name = "zip_code")
	private int zipCode;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "website")
	private String website;

	ShelterAccount() {
	}

	// this is temporary just for testing purposes.
	// TODO: REMOVE
	ShelterAccount(String email, String shelterName) {
		this.email = email;
		this.shelterName = shelterName;
	}

	ShelterAccount(String email, String passwordHash, String passwordSalt, String shelterName, String city, String street,
			String state, int zipCode, String phoneNumber, String website) {
		this.email = email;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
		this.shelterName = shelterName;
		this.city = city;
		this.street = street;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.website = website;
	}
}