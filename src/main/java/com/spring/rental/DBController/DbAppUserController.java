package com.spring.rental.DBController;

import com.spring.rental.dao.AppUserRepository;
import com.spring.rental.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class DbAppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/bulkcreate")
    public String bulkcreate(@RequestBody List<AppUser> users){
    // save a list of AppUsers

    appUserRepository.saveAll(users);
    return "AppUsers are created";
        }
        @PostMapping("/create")
    public String create(@RequestBody AppUser appUser){
        appUserRepository.save(appUser);
        return "Application user " + appUser.getLastName() + appUser.getFirstName() + " is created";
    }

    @GetMapping("/findall")
    public List<AppUser> findAll(){
        List<AppUser> users = appUserRepository.findAll();

        for (AppUser appUser: users) {
            users.add(new AppUser(appUser.getFirstName(), appUser.getLastName(), appUser.getAge(), appUser.getPhoneNumber(), appUser.getEmailAddress(), appUser.getRole()));
        }
        return users;
    }

}
