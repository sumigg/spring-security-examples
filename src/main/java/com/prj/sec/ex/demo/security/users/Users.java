package com.prj.sec.ex.demo.security.users;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Users implements UserDetails {

    private String userName;

    private String password;

    private String authority;



    public Users(String userName, String password, String authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(() -> authority);
    }

    @Override
    public @Nullable String getPassword() {
       return password;
    }

    @Override
    public String getUsername() {
      return userName;
    }

}
