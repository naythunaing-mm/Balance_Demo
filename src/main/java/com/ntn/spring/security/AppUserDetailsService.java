package com.ntn.spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ntn.spring.modal.repo.UserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public AppUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        var user = userRepo.findOneByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getLoginId())     
                .password(user.getPassword())        
                .roles(user.getRole().name())         // ✅ FIXED: use roles()
                .build();
    }
}
