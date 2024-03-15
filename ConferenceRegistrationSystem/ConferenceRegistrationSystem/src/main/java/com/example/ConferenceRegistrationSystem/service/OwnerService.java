package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Owner;
import com.example.ConferenceRegistrationSystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Owner registerOwner( Owner owner) {
        System.out.println(owner);
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        return ownerRepository.save(owner);
    }

    public Owner login(String username, String password)
    {
        return ownerRepository.findByUsernameAndPassword(username, password);
    }

}
