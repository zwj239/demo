package com.springclound.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springclound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springclound.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(login);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("账号不存在");
		} else {
			List<GrantedAuthority> grantedAuthorities = new ArrayList();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.get().getAuthority()));
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(login, user.get().getPassword(),
				grantedAuthorities);
			return userDetails;
		}

	}

}
