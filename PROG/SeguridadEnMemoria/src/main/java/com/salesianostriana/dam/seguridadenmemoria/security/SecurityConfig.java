package com.salesianostriana.dam.seguridadenmemoria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
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
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**").permitAll()
				.requestMatchers("/admin/***").hasAnyRole("ADMIN").anyRequest().authenticated())
				.formLogin((loginz) -> loginz.loginPage("/login")
						.permitAll()/*
									 * para cambiar la ruta .loginProcessingUrl("/ruta GetMapping") NO EL HTML, LA
									 * RUTA DEL CONTROLADOR
									 */ );
		// aquí tendría que meter lo que puede hacer el empleado
		// .hasAnyRole("ADMIN", "EMPLEADO") para sitios de los dos o
		// .hasAnyRole("EMPLEADO") para sitios de empleados.

		// Añadimos esto para poder seguir accediendo a la consola de H2
		// con Spring Security habilitado.
		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();
	}

	// Resto del código
}