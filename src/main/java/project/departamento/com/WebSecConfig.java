package project.departamento.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import project.departamento.com.security.UserService;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService service;

	@Autowired
	private Securityhandler securityhandler;

	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/Principal/**","/rest/visitante/**").authenticated()
				.antMatchers("/rest/usuario/**", "/rest/cliente/**").authenticated()
				.antMatchers("/rest/departamento/**", "/rest/controlvisita/**").authenticated()
				.antMatchers("/rest/consulta/**", "/rest/mascotas/**").authenticated().and().formLogin()
				.loginPage("/login").permitAll().usernameParameter("username").passwordParameter("password")
				.successHandler(securityhandler).and().headers().frameOptions().sameOrigin();
	}

}
