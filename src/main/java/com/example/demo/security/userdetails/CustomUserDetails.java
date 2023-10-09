package com.example.demo.security.userdetails;

import com.example.demo.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author scelac
 */
public class CustomUserDetails implements UserDetails {
  private Long id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Boolean accountNonLocked;
  private Boolean enabled;
  private Collection<? extends GrantedAuthority> authorities;

  public CustomUserDetails(
      Long id,
      String email,
      String password,
      List<UserRole> roleList,
      Boolean accountNonLocked,
      Boolean enabled,
      String firstName,
      String lastName) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.authorities = mapAuthority(roleList);
    this.accountNonLocked=accountNonLocked;
    this.enabled = enabled;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  //TODO how to do that?
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
  private Collection<? extends GrantedAuthority> mapAuthority(List<UserRole> roleNameList) {
    return roleNameList.stream()
            .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
            .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public Long getId() {
    return id;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
