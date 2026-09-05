package com.Project.post_comment.Service;

import com.Project.post_comment.Entity.User;
import com.Project.post_comment.Exception.ResourceNotFoundException;
import com.Project.post_comment.Payload.UserDto;
import com.Project.post_comment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;

  public User signUp(UserDto userDto) {
    userRepository.findByEmail(userDto.getEmail())
      .orElseThrow(()-> new ResourceNotFoundException("user not present with this id: "+userDto.getEmail()));
    User user = new User();
    user.setId(userDto.getId());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setRoles(userDto.getRoles());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByEmail(username)
      .orElseThrow(()-> new BadCredentialsException("user not found with email :" +username));
  }
}
