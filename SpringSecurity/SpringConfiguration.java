package CrudQueryWithSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigure {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDeailService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("varathan")
				.password(encoder.encode("PWD1")).
				roles("ADMIN").build();
		
		UserDetails hr = User.withUsername("arjun")
				.password(encoder.encode("PWD2")).
				roles("HR").build();
		UserDetails user = User.withUsername("raj")
				.password(encoder.encode("PWD3")).
				roles("USER").build();
		return new InMemoryUserDetailsManager(admin,hr);
		
		//return new UserInfoService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/student/{id}").permitAll()
		.and().authorizeHttpRequests().requestMatchers("/getStudents")
		.authenticated().and().formLogin().and().build();
		
	}
	


}
