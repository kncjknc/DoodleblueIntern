package CrudQueryWithSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import CrudQueryWithSecurity.service.UserInfoService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigure {
	
	
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    UserDetailsService userDeailService() {
		
//		UserDetails admin = User.withUsername("varathan")
//				.password(encoder.encode("PWD1")).
//				roles("ADMIN").build();
//		
//		UserDetails hr = User.withUsername("arjun")
//				.password(encoder.encode("PWD2")).
//				roles("HR").build();
//		return new InMemoryUserDetailsManager(admin,hr);
		
		return new UserInfoService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/student/{id}","/addUser").permitAll()
		.and().authorizeHttpRequests().requestMatchers("/getStudents")
		.authenticated().and().formLogin().and().build();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDeailService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
		
	}
	


}
