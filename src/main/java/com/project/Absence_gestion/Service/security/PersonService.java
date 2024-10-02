package com.project.Absence_gestion.Service.security;

import com.project.Absence_gestion.Repository.PerssoneRepository;
import com.project.Absence_gestion.exeption.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService implements UserDetailsService {

    private final PerssoneRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email).orElseThrow(()->(new PersonNotFoundException("No character has "+ email +" as a email")));
    }
}
