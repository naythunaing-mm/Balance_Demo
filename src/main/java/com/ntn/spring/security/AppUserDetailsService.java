package com.ntn.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ntn.spring.modal.repo.UserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return userRepo.findOneByLoginId(username)
//				.map(user -> User.withUsername(username)
//						.password(user.getPassword())
//						.authorities(AuthorityUtils.createAuthorityList(user.getRole().name()))
//						.disabled(!user.isActive())
//						.disabled(!user.isActive())
//						.build())
//				.orElseThrow(() -> new UsernameNotFoundException("There is no Username with Login ID %s".formatted(username)));
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepo.findOneByLoginId(username)
				.map(user -> User.withUsername(username)
						.password(user.getPassword())
						.authorities(AuthorityUtils.createAuthorityList(user.getRole().name()))
						.disabled(!user.isActive())
						.disabled(!user.isActive())
						.build()
						).orElseThrow(() -> new UsernameNotFoundException("There is no User name with Login ID %s".formatted(username)));
	}

}
