package com.nish.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


	@Bean
	UserDetailsService users(){

		return new InMemoryUserDetailsManager(

		User.builder()
		.username("admin")
		.password(passwordEncoder().encode("admin123"))
		.roles("ADMIN")
		.build(),

		User.builder()
		.username("user")
		.password(passwordEncoder().encode("user123"))
		.roles("USER")
		.build()
		);
	}


	@Bean
	SecurityFilterChain filter(HttpSecurity http)throws Exception{

		http.csrf(csrf->csrf.disable());

		http.authorizeHttpRequests(auth->auth

		.requestMatchers("/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**").permitAll()

		.requestMatchers(org.springframework.http.HttpMethod.GET,"/api/departments/**")
		.hasAnyRole("USER","ADMIN")

		.requestMatchers(org.springframework.http.HttpMethod.POST,"/api/departments/**")
		.hasRole("ADMIN")

		.requestMatchers(org.springframework.http.HttpMethod.PUT,"/api/departments/**")
		.hasRole("ADMIN")

		.requestMatchers(org.springframework.http.HttpMethod.DELETE,"/api/departments/**")
		.hasRole("ADMIN")

		.anyRequest().authenticated());

		http.httpBasic(Customizer.withDefaults());

		http.sessionManagement(session->
		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}


	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}