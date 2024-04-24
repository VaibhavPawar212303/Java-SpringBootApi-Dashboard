package com.example;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/actuator/**").permitAll() // Permit all requests to actuator endpoints
//                    .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults()); // Use HTTP Basic authentication
//    }
//}
