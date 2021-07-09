package br.com.agileschedule.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/", "/js/**", "/css/**", "/img/**").permitAll()
        .antMatchers(HttpMethod.GET, "/cadastro").permitAll()
        .antMatchers(HttpMethod.GET, "/cadastro*").permitAll()
        .antMatchers(HttpMethod.POST, "/cadastro").permitAll()
        .antMatchers(HttpMethod.GET, "/login").permitAll()
        .antMatchers(HttpMethod.GET, "/login*").permitAll()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .usernameParameter("email").defaultSuccessUrl("/").permitAll()
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/")).logoutSuccessUrl("/").permitAll();
    }
}