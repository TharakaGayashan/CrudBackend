package com.itfac.amc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.itfac.amc.jwt.AuthenticationRequest;
import com.itfac.amc.jwt.AuthenticationResponse;
import com.itfac.amc.jwt.JwtUtil;
import com.itfac.amc.security.MyUserDetailsService;
import com.itfac.amc.service.JwtAuthService;

@Service
public class JwtAuthServiceImpl implements JwtAuthService {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtUtil;

	@Override
	public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
