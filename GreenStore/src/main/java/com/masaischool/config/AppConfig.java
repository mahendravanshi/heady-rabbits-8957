//package com.masaischool.config;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AppConfig {
//
//	
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        		http.authorizeHttpRequests(
//        	
//        
//            auth -> {
//                auth.requestMatchers("/hello").permitAll()
//                .requestMatchers(HttpMethod.POST,"/customers").permitAll()
//                .requestMatchers("/welcome").hasAnyRole("ADMIN","USER")
//                .requestMatchers("/admin").hasRole("ADMIN")
//                .requestMatchers("/user").hasRole("USER")
//                .anyRequest().authenticated();
//                
//            }
//        ).csrf(c->c.disable())
//        .formLogin(Customizer.withDefaults())
//        .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    
//    /*
//    @Bean
//    public UserDetailsService getUser() {
//        UserDetails buildUser = User.withDefaultPasswordEncoder()
//        		 .username("abcd")
//                .password("12345")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(buildUser);
//    } */
//    
//    @Bean
//    public UserDetailsService getUser1() {
//        PasswordEncoder passwordEncoder = passwordEncoder();
//        UserDetails buildUser = User.withUsername("abcd")
//                .password(passwordEncoder.encode("12345"))
//                .roles("USER")
//                .build();
//        
//        UserDetails buildUser1 = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(buildUser,buildUser1);
//    }
//     
//    
//
//    
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//	
//	
//}
