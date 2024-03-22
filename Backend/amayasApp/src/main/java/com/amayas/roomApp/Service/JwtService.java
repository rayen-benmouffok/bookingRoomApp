package com.amayas.roomApp.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amayas.roomApp.Repository.UtilisateurRepository;

import com.amayas.roomApp.Entity.JwtRequest;
import com.amayas.roomApp.Entity.JwtResponse;
import com.amayas.roomApp.Entity.Utilisateur;
import com.amayas.roomApp.Util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository userDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {

		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		authenticate(userName, userPassword);
		
		final UserDetails userDetails = loadUserByUsername(userName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		Utilisateur  user = userDao.findByUserName(userName);
		return new JwtResponse(user, newGeneratedToken);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user = userDao.findByUserName(username);

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
					getAuthorities(user));
		} else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}

	private Set<SimpleGrantedAuthority> getAuthorities(Utilisateur user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	private void authenticate(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new Exception("User is disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad credentials from user");
		}

	}

}
