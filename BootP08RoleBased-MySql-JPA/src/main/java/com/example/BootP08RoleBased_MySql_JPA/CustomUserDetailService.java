package com.example.BootP08RoleBased_MySql_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service                                     // UserDetailsService this spring service load users  bydefault
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername method called....");
        AppUser user=userRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found "+username));
        System.out.println("Found username = "+user.getUsername() + " / " +user.getPassword());

        // load in memory of spring security
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" +role.getName()))
                        .toList()
        );
    }
}
