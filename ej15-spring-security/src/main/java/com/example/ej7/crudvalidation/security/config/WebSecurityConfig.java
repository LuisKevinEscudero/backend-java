package com.example.ej7.crudvalidation.security.config;

import com.example.ej7.crudvalidation.person.DTOs.PersonOutputDTO;
import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.repository.PersonRepository;
import com.example.ej7.crudvalidation.person.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private PersonRepository personRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder)
    {
//        Person person= personRepository.findById(idPerson).get();
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        if (person.getAdmin())
//        {
//            manager.createUser(User.withUsername(person.getUsername())
//                    .password(bCryptPasswordEncoder.encode(person.getPassword()))
//                    .roles("ADMIN")
//                    .build());
//        }
//        else
//        {
//            manager.createUser(User.withUsername(person.getUsername())
//                    .password(bCryptPasswordEncoder.encode(person.getPassword()))
//                    .roles("USER")
//                    .build());
//        }

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("admin"))
                .roles("ADMIN")
                .build());
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("user"))
                .roles("USER")
                .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       return  http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth ->{
                    auth.antMatchers("/publico").permitAll();
                    auth.antMatchers("/ADMIN").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
