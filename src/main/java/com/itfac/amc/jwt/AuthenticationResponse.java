package com.itfac.amc.jwt;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationResponse {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

}
