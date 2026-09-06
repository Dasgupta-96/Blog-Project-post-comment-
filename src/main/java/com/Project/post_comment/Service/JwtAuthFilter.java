//package com.Project.post_comment.Service;
//
//import com.Project.post_comment.Entity.User;
//import com.Project.post_comment.Repository.UserRepository;
//import com.Project.post_comment.util.JwtUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//@Service
//@RequiredArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//  private final JwtUtil jwtUtil;
//  private final UserRepository userRepository;
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//    throws ServletException, IOException {
//
//    try {
//      String reqTokenHeader = request.getHeader("Authorization");
//      if (reqTokenHeader == null || !reqTokenHeader.startsWith("Bearer ")) {
//        filterChain.doFilter(request, response);
//        return;
//      }
//      String token = reqTokenHeader.split("Bearer ")[1];
//      Long id = jwtUtil.getIdFromToken(token);
//      User user = userRepository.findById(Math.toIntExact(id))
//        .orElseThrow(() -> new UsernameNotFoundException("user not found with id"));
//
//      if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//        SecurityContextHolder.getContext().setAuthentication(
//          new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())
//        );
//      }
//      filterChain.doFilter(request, response);
//    }
//    catch (Exception e) {
//      throw new RuntimeException("token not found", e);
//    }
//  }
//}