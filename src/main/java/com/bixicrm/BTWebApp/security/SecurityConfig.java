/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.security;


import com.bixicrm.BTWebApp.repository.UserDAO;
import com.bixicrm.BTWebApp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author gavin
 */

@Configuration
public class SecurityConfig {
    
    
    @Autowired
    private final UserService userservice;

    public SecurityConfig(UserService userservice) {
        this.userservice = userservice;
    }
    
    
    
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//    {
//       return http.formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(req -> req
//                .requestMatchers("/**").permitAll()
//                .requestMatchers("/login/**").permitAll()
//                .requestMatchers("/userdash/**").hasAnyAuthority("user", "admin")
//                .requestMatchers("/dashboard/**").hasAnyAuthority("admin")
//                .anyRequest().authenticated())
//                .userDetailsService(userservice).build();
//    }
    
    
@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserDAO userdao;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
       @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Allow access to common static resources like images, CSS, etc.
                    .requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll() // Permit access to /register/** for everyone
                    .requestMatchers(new AntPathRequestMatcher("/")).permitAll() // Permit access to / for everyone
//                    .requestMatchers(new AntPathRequestMatcher("/dashboard")).hasRole("Admin") // Allow access
//                    .requestMatchers(new AntPathRequestMatcher("/index/**")).authenticated() // Require authentication
//                    .requestMatchers(new AntPathRequestMatcher("//**")).authenticated() // Require authentication 
//                    .requestMatchers(new AntPathRequestMatcher("//**")).authenticated() // Require authentication
                    .requestMatchers(new AntPathRequestMatcher("/login")).permitAll() // Allow access to /login 
                    .requestMatchers(new AntPathRequestMatcher ("/addUser")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher ("/saveUser")).permitAll()
                     .requestMatchers(new AntPathRequestMatcher ("/getUsers/**")).permitAll()
                       .requestMatchers(new AntPathRequestMatcher ("/editUser/{id}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/editSaveUser")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/deleteUser/{id}")).permitAll()
                        
                        
                        
                        
                        
                        // Allow Access to Dashboard URL's 
                    .requestMatchers(new AntPathRequestMatcher ("/dashboard")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/userdash")).permitAll()
                        
                        
                        // Allow Access to Client URL's
                           .requestMatchers(new AntPathRequestMatcher ("/Client")).permitAll()
                           .requestMatchers(new AntPathRequestMatcher ("/getClients")).permitAll()        
                        .requestMatchers(new AntPathRequestMatcher ("/saveClient")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/editClient/{id}")).permitAll()
                           .requestMatchers(new AntPathRequestMatcher ("/editSaveClient")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/deleteClient/{id}")).permitAll()
                        
                        
                        // Allow Access to Contact URLs
                        .requestMatchers(new AntPathRequestMatcher ("/getContacts")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/Contact")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/saveContact")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/editContact/{id}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/editSaveContact")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher ("/deleteContact/{id}")).permitAll()
                         .requestMatchers(new AntPathRequestMatcher ("/contact/{id}")).permitAll()
                        
                        
                    
//                  
                    
             )
             .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/userdash") // Default success URL for all authenticated users
                .successHandler((request, response, authentication) -> {
                    for (GrantedAuthority authority : authentication.getAuthorities()) {
                        if (authority.getAuthority().equals("Admin")) {
                            response.sendRedirect("/dasboard"); 
                            return;
                        }
                    }
                    response.sendRedirect("/"); // Redirect to /index for non-admin users
                })
                .permitAll()
            )
                .logout(logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Disabling CSRF protection
            return http.build();



}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	            .userDetailsService(userDetailsService)
	            //.passwordEncoder(passwordEncoder())
	            .passwordEncoder(bCryptPasswordEncoder())
	            ;
	}
	
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
    }


    
    
    

}

    

