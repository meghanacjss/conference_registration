package com.example.ConferenceRegistrationSystem.config;

import com.example.ConferenceRegistrationSystem.entity.Owner;
import com.example.ConferenceRegistrationSystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;
public class UserUserService implements UserDetailsService {
@Autowired
private OwnerRepository ownerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Owner> owner = ownerRepository.findByName(username);
        System.out.println(owner.get().getPassword());
        return  owner.map(com.example.ConferenceRegistrationSystem.config.UserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("user not found"+username));
    }
}








//Owner owner = ownerRepository.findByUsername(username)
//        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//
//        return new UserDetailsService(owner);