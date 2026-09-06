package com.Project.post_comment.util;
import com.Project.post_comment.Entity.User;
import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
  @Value("${jwt.secret.key}")
  private String secretKey;

  private SecretKey getSecretKey(){
    return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
  }
  public String generateAcessToken(User user) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + (5 * 60 * 1000));
    return Jwts.builder()
      .setSubject(String.valueOf(user.getId()))
      .claim("username", user.getUsername())
      .claim("email",user.getEmail())
      .claim("roles",user.getRoles().toString())
      .setIssuedAt(new Date())
      .setExpiration(expiryDate)
      .signWith(getSecretKey())
      .compact();
  }
  public String generateRefreshToken(User user) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + (7L * 24 * 60 * 60 * 1000));
    return Jwts.builder()
      .setSubject(String.valueOf(user.getId()))
      .claim("username", user.getUsername())
      .claim("email",user.getEmail())
      .claim("roles",user.getRoles().toString())
      .setIssuedAt(new Date())
      .setExpiration(expiryDate)
      .signWith(getSecretKey())
      .compact();
  }

  public Long getIdFromToken(String token) {
    Claims claims = Jwts.parser()
      .setSigningKey(getSecretKey())
      .parseClaimsJws(token)
      .getBody();
    return Long.valueOf(claims.getSubject());

  }
}

