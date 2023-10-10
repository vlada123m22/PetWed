package com.example.demo.configuration.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("customSimpleUrlAuthenticationSuccessHandler")
public class CustomSimpleUrlAuthenticationSuccessHandler
    extends SimpleUrlAuthenticationSuccessHandler {
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Override
  protected void handle(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    redirectStrategy.sendRedirect(request, response, determineTargetUrl(authentication));
  }

  protected String determineTargetUrl(Authentication authentication) {
    String url = null;
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    List<String> roles = new ArrayList<>();

    for (GrantedAuthority a : authorities) {
      roles.add(a.getAuthority());
    }

    if (roles.contains("ADMIN")) {
      url = "/admin-dashboard";
    } else if (roles.contains("REGISTERED")) {
      url = "/profile";
    } else if (roles.contains("GUEST")) {
      url = "/";
    }

    return url;
  }
}
