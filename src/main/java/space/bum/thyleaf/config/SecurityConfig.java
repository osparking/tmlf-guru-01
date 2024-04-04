package space.bum.thyleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  UserDetailsService userDetailsService(PasswordEncoder encoder) {

    // InMemoryUserDetailsManager
    UserDetails admin = User.withUsername("admin")
        .password(encoder.encode("admin"))
        .roles("ADMIN", "USER")
        .build();

    UserDetails user = User.withUsername("user")
        .password(encoder.encode("user"))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user);
  }

  // Configuring HttpSecurity
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http)
      throws Exception {
    return http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/auth/welcome").permitAll())
        .authorizeHttpRequests(
            requests -> requests.requestMatchers("/auth/user/**")
                .authenticated())
        .authorizeHttpRequests(
            requests -> requests.requestMatchers("/auth/admin/**")
                .authenticated())
        .formLogin(Customizer.withDefaults()).build();
  }

  // Password Encoding
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}