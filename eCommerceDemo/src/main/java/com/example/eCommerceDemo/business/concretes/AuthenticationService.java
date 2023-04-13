package com.example.eCommerceDemo.business.concretes;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.eCommerceDemo.business.requests.AuthenticationRequest;
import com.example.eCommerceDemo.business.requests.RegisterRequest;
import com.example.eCommerceDemo.business.responses.AuthenticationResponse;
import com.example.eCommerceDemo.config.JwtService;
import com.example.eCommerceDemo.core.dataAccess.abstracts.UserRepository;
import com.example.eCommerceDemo.core.entities.User;
import com.example.eCommerceDemo.core.entities.enums.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		userRepository.save(user);
		
		var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
	    authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                request.getEmail(),
	                request.getPassword()
	            )
	        );
		
	    var user = userRepository.findByEmail(request.getEmail())
	            .orElseThrow();
	    var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

}
