package com.prj.sec.ex.demo.security.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.prj.sec.ex.demo.security.users.InMemoryUserDetailsService;
import com.prj.sec.ex.demo.security.users.Users;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u = new Users("dev", "test", "write");
        return new InMemoryUserDetailsService(List.of(u));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception
    {
      http.httpBasic(Customizer.withDefaults());
      http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
     // http.authorizeHttpRequests(c -> c.anyRequest().permitAll());


      return http.build();


    }

}
