//package com.Project.post_comment.Controller;
//
//import com.Project.post_comment.Entity.User;
//import com.Project.post_comment.Exception.ResourceNotFoundException;
//import com.Project.post_comment.Payload.LoginDto;
//import com.Project.post_comment.Payload.LoginResponseDto;
//import com.Project.post_comment.Payload.UserDto;
//import com.Project.post_comment.Repository.UserRepository;
//import com.Project.post_comment.Service.AuthService;
//import com.Project.post_comment.Service.SessionService;
//import com.Project.post_comment.Service.UserService;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.Iterator;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//  @Autowired
//  private UserRepository userRepository;
//  @Autowired
//  private AuthService authService;
//  @Autowired
//  private UserService userService;
//  @Autowired
//  private SessionService sessionService;
//
//  @Value("${deploy.env}")
//  private String deployEnv;
//
//  @PostMapping("/signup")
////  @RequestMapping(value = "/signup",method = RequestMethod.POST, consumes = "application/json")
////   http://localhost:8080/auth/signup
//  public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
//    User user = userService.signUp(userDto);
//    return ResponseEntity.ok(user);
//  }
//
//  @PostMapping("/signin")
//  // http://localhost:8080/auth/signin
//  public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginDto loginDto, HttpServletResponse response) {
//    LoginResponseDto loginResponseDto = authService.login(loginDto);
//    User user = userRepository.findByEmail(loginDto.getEmail())
//      .orElseThrow(() -> new ResourceNotFoundException("User not present"));
//    // for session based validation -> suppose i want only one user's device(one session) to be active at a time
//    sessionService.generateNewSession(user, loginResponseDto.getRefreshToken());
//    Cookie cookie = new Cookie("refreshToken", loginResponseDto.getRefreshToken());
//    cookie.setHttpOnly(true);
//    cookie.setSecure("production".equals(deployEnv));
//    response.addCookie(cookie);
//    return ResponseEntity.ok(loginResponseDto);
//
//  }
//  @PostMapping("/refresh")
//  public ResponseEntity<LoginResponseDto> generateRefreshToken(HttpServletRequest request) {
//    String token = Arrays.stream(request.getCookies())
//      .filter(cookie -> "refreshToken".equals(cookie.getName()))
//      .findFirst()
//      .map(Cookie::getValue)
//      .orElseThrow(()-> new ResourceNotFoundException("RefreshToken is not present inside cookie"));
//    sessionService.validateRefreshToken(token);
//    LoginResponseDto loginResponseDto = authService.generateRefreshToken(token);
//    return ResponseEntity.ok(loginResponseDto);
//  }
//}
//
