package com.salesianostriana.dam.pruebaproyecto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
		http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**").permitAll()

				.requestMatchers("/empleado/**").hasAnyRole("EMPLEADO", "ADMIN")

				.requestMatchers("/admin/**").hasAnyRole("ADMIN")

				.anyRequest().authenticated())

				.formLogin((loginz) -> loginz.loginPage("/login").defaultSuccessUrl("/main")
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
