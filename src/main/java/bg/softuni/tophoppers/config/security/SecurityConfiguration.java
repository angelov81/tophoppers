package bg.softuni.tophoppers.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  final PasswordEncoder passwordEncoder;

  public SecurityConfiguration(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user")
        .password(passwordEncoder.encode("pass")).roles("USER")
        .and()
        .withUser("admin")
        .password(passwordEncoder.encode("admin")).roles("ADMIN", "USER");
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeRequests()
        .antMatchers("/index").permitAll()
        .antMatchers("/categories.html").hasRole("ADMIN")
        .antMatchers("/farms.html").hasRole("ADMIN")
        .antMatchers("/products.html").hasRole("USER")
        .and()
        .formLogin();

    // Temp solution until login is implemented, TODO: delete me
//    httpSecurity.csrf().disable();
//    httpSecurity.headers().frameOptions().disable();

  }

}
