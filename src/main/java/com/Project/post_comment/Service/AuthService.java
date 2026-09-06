//package com.Project.post_comment.Service;
//
//import com.Project.post_comment.Entity.User;
//import com.Project.post_comment.Payload.LoginDto;
//import com.Project.post_comment.Payload.LoginResponseDto;
//import com.Project.post_comment.Repository.SessionRepository;
//import com.Project.post_comment.Repository.UserRepository;
//import com.Project.post_comment.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//public class AuthService {
//  @Autowired
//  private UserRepository userRepository;
//
//  @Autowired
//  private SessionRepository sessionRepository;
//  @Autowired
//  private PasswordEncoder passwordEncoder;
//  @Autowired
//  private JwtUtil jwtUtil;
//  @Autowired
//  private AuthenticationManager authenticationManager;
//
//  public LoginResponseDto login(LoginDto loginDto) {
//    Authentication authentication = authenticationManager.authenticate(
//      new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
//);
//    User user = (User) authentication.getPrincipal();
//    String accessToken = jwtUtil.generateAcessToken(user);
//    String refreshToken = jwtUtil.generateRefreshToken(user);
//
//    return new LoginResponseDto(user.getId(), accessToken, refreshToken);
//
//  }
//
//  public LoginResponseDto generateRefreshToken(String token) {
//    Long userId = jwtUtil.getIdFromToken(token);
//
//    User user = userRepository.findById(Math.toIntExact(userId))
//      .orElseThrow(() -> new UsernameNotFoundException("User not present with this id"));
//
//    String accessToken = jwtUtil.generateAcessToken(user);
//    String refreshToken = jwtUtil.generateRefreshToken(user);
//
//    return new LoginResponseDto(user.getId(), accessToken, refreshToken);
//  }
//}
