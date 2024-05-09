package com.salesianostriana.dam.pruebaproyecto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();

	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**").permitAll()
				/* .requestMatchers("/empleado/***").hasAnyRole("EMPLEADO") */
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

}
