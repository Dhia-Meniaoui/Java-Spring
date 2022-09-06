package com.project.bimapispring.repositories;


import com.project.bimapispring.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String Username);
}
