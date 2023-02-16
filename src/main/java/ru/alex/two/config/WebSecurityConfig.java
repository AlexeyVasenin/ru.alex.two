package ru.alex.two.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
       /* http
                .authorizeRequests()
                .antMatchers("/", "/swagger-ui.html", "/regis").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .permitAll()
                .and()
                .logout()
                .permitAll();*/
    }

  /*  @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
               *//* User.builder()
                        .username("admin")
                        .password(encode().encode("admin"))
                        .roles(Role.AMDIN.name())
                        .build(),*//*

                User.builder()
                        .username("user")
                        .password("8909")
                        .roles("USER")
                        .build()
        );
    }*/

   /* @Bean
    protected PasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }*/

}
