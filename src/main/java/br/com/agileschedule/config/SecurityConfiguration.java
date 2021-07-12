package br.com.agileschedule.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.agileschedule.service.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
	
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
	      .antMatchers(HttpMethod.GET, "/cadastro").permitAll()
	      .antMatchers(HttpMethod.GET, "/cadastro/**").permitAll()
	      .antMatchers(HttpMethod.POST, "/cadastro").permitAll()
	      .antMatchers(HttpMethod.GET, "/login").not().authenticated()
	      .antMatchers(HttpMethod.GET, "/login/**").permitAll()
	      .antMatchers(HttpMethod.POST, "/login").permitAll()
	      .anyRequest().authenticated()
	      .and().formLogin().loginPage("/login").permitAll()
	      .usernameParameter("email").defaultSuccessUrl("/api").permitAll()
	      .and().logout()
	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
	  }

	  @Override
	  public void configure(WebSecurity ws) throws Exception {
		  ws.ignoring().antMatchers("/**.html", "/css/**", "/images/**", "/img/**", "/js/**", "/h2-console/**" ,"/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**", "/swagger.json", "/swagger-ui.html");
	  }

	  public static void main(String[] args) {
		  BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		  String a = bc.encode("1234");
		  System.out.println(a);
	  }
}
