package com.mql.notesProject.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mql.notesProject.entities.User;

@Service
public class ImplUserDetailService implements UserDetailsService {
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User loadedUser = accountService.findByUsername(username);
		if (loadedUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("Admin"));
		authorities.add(new SimpleGrantedAuthority("User"));
		return new org.springframework.security.core.userdetails.User(loadedUser.getUsername(),
				loadedUser.getPassword(), authorities);

	}

}
