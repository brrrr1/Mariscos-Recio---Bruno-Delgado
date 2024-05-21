package com.salesianostriana.dam.brunodelgadoherreroproyecto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();

	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/css/**", "/js/**", "/audio/**", "img/**", "/perfil/**", "/buscar/**", "/video/**").permitAll()

				.requestMatchers("/empleados/**", "/addFavorito/**").hasAnyRole("EMPLEADO", "ADMIN")

				.requestMatchers("/admin/**",  "/h2-console/**").hasAnyRole("ADMIN")

				.anyRequest().permitAll())

				.formLogin((loginz) -> loginz.loginPage("/login").defaultSuccessUrl("/main").permitAll())
				.logout((logoutz) -> logoutz.logoutUrl("/logout").logoutSuccessUrl("/main").permitAll())
				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/error"));

		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	 * Exception { http.authorizeHttpRequests( (authz) ->
	 * authz.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll())
	 * .formLogin((loginz) ->
	 * loginz.loginPage("/login").defaultSuccessUrl("/").permitAll());
	 * 
	 * http.csrf(csrfz -> csrfz.disable()); http.headers(headersz ->
	 * headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));
	 * 
	 * return http.build(); }
	 */

}