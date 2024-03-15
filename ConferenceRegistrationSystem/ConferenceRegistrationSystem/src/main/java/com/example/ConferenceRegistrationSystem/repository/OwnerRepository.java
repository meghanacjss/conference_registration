package com.example.ConferenceRegistrationSystem.repository;

import com.example.ConferenceRegistrationSystem.entity.Owner;
import com.example.ConferenceRegistrationSystem.model.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {

    Owner findByUsernameAndPassword(String username, String password);
//    @Query("SELECT o FROM Owner o WHERE o.username = :username")
//    Optional<Owner> findByName(@Param("username") String username);

    Optional<Owner> findByName(String username);
}
