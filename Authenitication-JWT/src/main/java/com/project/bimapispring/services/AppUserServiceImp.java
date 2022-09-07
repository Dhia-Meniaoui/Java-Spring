package com.project.bimapispring.services;

import com.project.bimapispring.models.AppUser;
import com.project.bimapispring.models.Role;
import com.project.bimapispring.repositories.AppUserRepository;
import com.project.bimapispring.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserServiceImp implements AppUserService{

    @Autowired
    private final AppUserRepository appuserRepository;
    @Autowired
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public AppUser saveAppUser(AppUser user) {
        log.info("savin new user to the data base");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appuserRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String rolename) {
        AppUser user = appuserRepository.findByUsername(username);
        System.out.print(user);
        Role role = roleRepository.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getAppUser(String username) {
        return appuserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllAppUser() {
        return appuserRepository.findAll();
    }
}
