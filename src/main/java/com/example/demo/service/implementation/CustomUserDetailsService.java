package com.example.demo.service.implementation;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.userdetails.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    final User user = userRepository.getByEmail(email);
    if (Objects.isNull(user)) {
      throw new UsernameNotFoundException("Username not found");
    }
    return new CustomUserDetails(
        user.getId(),
        user.getEmail(),
        user.getPassword(),
            Arrays.asList(user.getUserRole()),
        true,
        user.getFirstName(),
        user.getLastName());
  }
}
