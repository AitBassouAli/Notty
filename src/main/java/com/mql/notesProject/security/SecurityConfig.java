package com.mql.notesProject.security;

import javax.servlet.Filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(userDetailsService).
	     passwordEncoder(bcryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		
		//désactiver authentification basé sur les sessions 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// en indique qu'on va utiliser le formulaire d'auhtentification de spring
		// pour utiliser un formumaire d'authenfication qui nous avons crees nous memem
		// http.formLogin().loginPage("/login");
		//http.formLogin();
		//donner les permission a la page login et register user
		
		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
        //en indique a spring que toutes les requetes Post il font que l'utilisateur soyez admine .
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/notes/**").hasAuthority("User");
	
		// tous les ressources de lapplication passeront par spring security
//		http.authorizeRequests().anyRequest().authenticated();
//		http.addFilter(new JWTAuthenticationFiltre(authenticationManager()));
//		http.addFilterBefore(new JWTAuthorizationFiltre(),(Class<? extends Filter>) UsernamePasswordAuthenticationFilter.class);
		super.configure(http);
	}

}
