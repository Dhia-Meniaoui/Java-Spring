package com.project.bimapispring;

import com.project.bimapispring.models.AppUser;
import com.project.bimapispring.models.ERole;
import com.project.bimapispring.models.Role;
import com.project.bimapispring.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class BimApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BimApiSpringApplication.class, args);
        System.out.print("dhia");
    }


    @Bean
    CommandLineRunner run(AppUserService appUserService){
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_AGENCY"));
            Role asd = appUserService.saveRole(new Role(null, "ROLE_USER"));

            System.out.print(asd);


            appUserService.saveAppUser(new AppUser(null, "dhia" , "Dhia" , "Meniaoui" , "dhiaminiaiuo@gmail.com" , "asdf" , "46865432663" , new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "waga" , "Dhia" , "Meniaoui" , "wega@gmail.com" , "asdf" , "6871" , new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "berlin" , "berlin" , "Meniaoui" , "berlin@gmail.com" , "asdf" , "786" , new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "paris" , "paris" , "Meniaoui" , "paris@gmail.com" , "asdf" , "5457" , new ArrayList<>()));

            appUserService.addRoleToAppUser("dhia", "ROLE_ADMIN");
            appUserService.addRoleToAppUser("dhia", "ROLE_USER");
            appUserService.addRoleToAppUser("waga", "ROLE_USER");
            appUserService.addRoleToAppUser("berlin", "ROLE_USER");
            appUserService.addRoleToAppUser("paris", "ROLE_AGENCY");

        };
    }
}
