package com.brillio.omnistore.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brillio.omnistore.model.Login;
import com.brillio.omnistore.user.repository.LoginRepository;

@Service
public class LoginDetailsServiceImpl implements UserDetailsService {
	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = loginRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return LoginDetailsImpl.build(login);
	}

}
