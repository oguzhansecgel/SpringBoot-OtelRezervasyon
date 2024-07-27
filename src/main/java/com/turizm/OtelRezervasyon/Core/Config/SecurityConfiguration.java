package com.turizm.OtelRezervasyon.Core.Config;

import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.UserService;
import com.turkcell.tcell.core.annotations.EnableSecurity;
import com.turkcell.tcell.core.security.BaseSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final BaseSecurityService baseSecurityService;

    private static final String[] WHITE_LIST = {
            "/api/v1/auth/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/v1/**",
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        baseSecurityService.configureCommonSecurityRules(http);
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.POST, "/api/v1/auth/register").hasAnyAuthority("Admin")
                                .requestMatchers(HttpMethod.GET, "/api/users/getAllUsers").hasAnyAuthority("Admin")


                                .requestMatchers(HttpMethod.GET, "/api/v1/hotel/getAll").hasAnyAuthority("Personel","Admin")
                                .requestMatchers(HttpMethod.POST, "/api/v1/hotel/create").hasAnyAuthority("Personel","Admin")

                                .requestMatchers(HttpMethod.GET, "/api/v1/room/getAll").hasAnyAuthority("Personel","Admin")
                                .requestMatchers(HttpMethod.POST, "/api/v1/room/create").hasAnyAuthority("Personel","Admin")

                                .requestMatchers(HttpMethod.GET, "/api/v1/reservation/getAll").hasAnyAuthority("Personel","Admin")
                                .requestMatchers(HttpMethod.POST, "/api/v1/reservation/createReservation").hasAnyAuthority("Personel","Admin")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/reservation/deleteReservation/{id}").hasAnyAuthority("Personel","Admin")
                                .requestMatchers(HttpMethod.POST, "/api/v1/reservation/updateReservation/{id}").hasAnyAuthority("Personel","Admin")

                                .requestMatchers("/api/v1/hotel/**").authenticated()
                                .requestMatchers("/api/v1/room/**").authenticated()
                                .requestMatchers("/api/v1/reservation/**").authenticated()
                                .anyRequest().permitAll()
                );
        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
//Personel admin

//Dönem Yönetimi: Dönem listeleme, ekleme
//Fiyat Yönetimi
//Oda Arama
