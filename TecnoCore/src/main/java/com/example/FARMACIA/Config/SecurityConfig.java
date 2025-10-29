package com.example.FARMACIA.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login", "/registro", 
				"/detalle-ventas", "/historial-stock", "/metodos-pago", "/productos",
				"/clientes","/proveedores","/usuarios","/ventas",
				
				"/categorias","/css/**", "/js/**", "/img/**").permitAll()
				.anyRequest().authenticated()
			)
			.csrf().disable() // Deshabilitar CSRF para pruebas
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout(logout -> logout.permitAll());
		return http.build();
	}
}