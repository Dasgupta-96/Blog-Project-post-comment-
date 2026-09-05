package com.Project.post_comment.Config;

import com.Project.post_comment.Entity.Role;
import com.Project.post_comment.Service.JwtAuthFilter;
import com.Project.post_comment.security.CustomAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.time.temporal.ChronoUnit;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

private static final String[] publicRoutes = {
  "/auth/**","/api/posts","/actuator/**","/book/**"
};
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())  // Correct way to disable CSRF in Spring Security 6.1
          .authorizeHttpRequests(auth -> auth
            .requestMatchers(publicRoutes).permitAll()
            .requestMatchers( "/admin.html",
              "/customer.html",
              "/ws/**",
              "/topic/**",
              "/app/**",
              "/static/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/posts/**").hasRole(Role.ADMIN.name())
            .requestMatchers(HttpMethod.PUT, "/api/posts/**").hasRole(Role.ADMIN.name())

            .anyRequest().authenticated()

          ).exceptionHandling(ex->
            ex.accessDeniedHandler(customAccessDeniedHandler))
          .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/**").permitAll()
//                .antMatchers(HttpMethod.PATCH, "/api/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//        @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user = User.builder().username("ankit").password(passwordEncoder()
//                .encode("ankit")).roles("USER").build();
//        UserDetails admin = User.builder().username("deb").password(passwordEncoder()
//                .encode("deb")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

}

