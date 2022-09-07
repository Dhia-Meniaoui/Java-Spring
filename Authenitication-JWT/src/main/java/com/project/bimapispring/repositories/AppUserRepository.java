package com.project.bimapispring.repositories;


import com.project.bimapispring.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String Username);

    @Query("SELECT u FROM AppUser u WHERE u.username = ?1 OR u.email = ?1 OR u.phone = ?1")
    Optional<AppUser> findByUsernameOrEmailOrPhone(String username);
}
