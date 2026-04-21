package com.prj.sec.ex.demo.security.users;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> usersList;

    public InMemoryUserDetailsService(List<UserDetails> usersList) {
        this.usersList = usersList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return usersList.stream().filter(u -> u.getUsername().equals(username)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

}
