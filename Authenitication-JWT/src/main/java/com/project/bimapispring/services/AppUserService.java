package com.project.bimapispring.services;

import com.project.bimapispring.models.AppUser;
import com.project.bimapispring.models.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToAppUser(String username, String role);

    AppUser getAppUser(String username);

    List<AppUser> getAllAppUser();
}
