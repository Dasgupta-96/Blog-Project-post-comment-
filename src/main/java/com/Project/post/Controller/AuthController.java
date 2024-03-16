package com.Project.post.Controller;

import com.Project.post.Config.JwtTokenProvider;
import com.Project.post.Entity.JWTAuthResponse;
import com.Project.post.Entity.Role;
import com.Project.post.Entity.User;
import com.Project.post.Payload.LoginDto;
import com.Project.post.Payload.SignUpDto;
import com.Project.post.Repository.RoleRepository;
import com.Project.post.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }



    @PostMapping("/signup")
    //http://localhost:8080/api/auth/signup
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

        if (userRepository.existsByEmail(signUpDto.getEmail())) {

            return new ResponseEntity<>("Email already exists!!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByUsername(signUpDto.getUsername())) {

            return new ResponseEntity<>("Username already exists!!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setId(signUpDto.getId());
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setUsername(signUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN").get();

        Set<Role> convertRoleTOset = new HashSet<>();
        convertRoleTOset.add(role);
        user.setRoles(convertRoleTOset);
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfullly!!", HttpStatus.CREATED);
    }
}