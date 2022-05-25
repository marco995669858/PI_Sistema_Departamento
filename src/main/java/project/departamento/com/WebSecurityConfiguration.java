//package project.departamento.com;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	
//	
//	@Autowired
//	private UserDetailsService detailsService;
//	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(detailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
// 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		/***
//		 * 
//		 * Para agregar otra ruta a un determinado rol se le agreaga lantMatchers("RUTA","RUTA","RUTA")
//		 * IMPORTANTE COLOCAR "/**" DESPUES DE COPIAR LA RUTA
//		 */
//		http.authorizeRequests().antMatchers(
//				"/resources/**",
//				"/alertifyjs/**",
//				"/static/**",
//				"/js/**",
//				"/css/**",
//				"/datepicker/**").permitAll()
//		.antMatchers("/rest/usuario/**","/rest/cliente/**", "/rest/controlvisita/**",
//				"/rest/departamento/**", "/res/mascotas/**", "/rest/visitante/**")
//		.hasAuthority("Administrador")
//		.antMatchers("/rest/controlvisita/**")
//		.hasAuthority("Counter")
//		.antMatchers("/rest/visitante/**")
//		.hasAnyAuthority("Propietario","Residente")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login").permitAll()
//		.and()
//		.logout()
//		.invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/login?logout")
//		.permitAll();
//	}
//	
//}
