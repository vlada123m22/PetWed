package com.example.demo.configuration.security;

import com.example.demo.service.implementation.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false)
public class LocalSecurityConfig {
  private final CustomUserDetailsService customUserDetailsService;
  private final CustomSimpleUrlAuthenticationSuccessHandler
      customSimpleUrlAuthenticationSuccessHandler;

  public LocalSecurityConfig(
      CustomUserDetailsService customUserDetailsService,
      CustomSimpleUrlAuthenticationSuccessHandler customSimpleUrlAuthenticationSuccessHandler) {
    this.customUserDetailsService = customUserDetailsService;
    this.customSimpleUrlAuthenticationSuccessHandler = customSimpleUrlAuthenticationSuccessHandler;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(5);
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(customUserDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .authenticationProvider(authProvider())
        .build();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (authorizeHttpRequests) ->
                authorizeHttpRequests.requestMatchers("/**", "/login").permitAll()
            /**
             * This part below are not working as expected in current version of spring boot for
             * restrict access to: /admin-dashboard/** /sale-dashboard/** /user/** like a solution
             * needs to annotate every controller method with @PreAuthorize("hasRole('ADMIN')") +
             * corresponding role for restriction .requestMatchers("/admin-dashboard**",
             * "/sale-dashboard/**") .hasRole("ADMIN") .requestMatchers("/sale-dashboard/**")
             * .hasRole("SALE_MANAGER") .requestMatchers("/user/**")
             * .hasAnyRole("SALE_MANAGER,ADMIN")
             */
            )
        .formLogin(
            form ->
                form.usernameParameter("userEmail")
                    .passwordParameter("password")
                    .loginPage("/login.html")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login.html?error=true")
                    .loginProcessingUrl("/login")
                    .successHandler(customSimpleUrlAuthenticationSuccessHandler))
        .logout(
            logout ->
                logout
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login.html"));

    return http.build();
  }
}
