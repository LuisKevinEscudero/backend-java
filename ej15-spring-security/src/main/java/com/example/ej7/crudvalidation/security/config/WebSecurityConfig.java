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

import java.util.List;


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
        List<Person> personList = personRepository.findAll();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        for (Person person : personList) {
            if (person.getAdmin())
            {
                manager.createUser(User.withUsername(person.getUsername())
                        .password(bCryptPasswordEncoder.encode(person.getPassword()))
                        .roles("ADMIN")
                        .build());
            }
            else
            {
                manager.createUser(User.withUsername(person.getUsername())
                        .password(bCryptPasswordEncoder.encode(person.getPassword()))
                        .roles("USER").build());
            }

        }

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       return  http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth ->{
                    auth.antMatchers("/**").hasRole("ADMIN");
                    auth.antMatchers("/USER/**").hasRole("USER");
                    auth.anyRequest().authenticated();
                    //auth.anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
