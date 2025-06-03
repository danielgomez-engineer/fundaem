package com.fundaem.fundaem.security;

import com.fundaem.fundaem.serviceImpl.UsuarioDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    // Rutas públicas accesibles sin autenticación
    public static final String[] PUBLIC_ROUTES = {
            "/", "/index.html",
            "/css/**", "/js/**", "/img/**", "/video/**",
            "/api/auth/**", "/api/usuarios",
            "/login", "/register"
    };
    // Rutas solo para administradores
    public static final String[] ADMIN_ROUTES = {
            "/admin/**"
    };
    // Rutas solo para usuarios autenticados
    public static final String[] USER_ROUTES = {
            "/user/**"
    };

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UsuarioDetailsServiceImpl usuarioDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas
                        .requestMatchers(PUBLIC_ROUTES).permitAll()
                        // Rutas de admin
                        .requestMatchers(ADMIN_ROUTES).hasRole("ADMIN")
                        // Rutas de usuario
                        .requestMatchers(USER_ROUTES).hasAnyRole("USER", "ADMIN")
                        // Todo lo demás requiere autenticación
                        .anyRequest().authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
