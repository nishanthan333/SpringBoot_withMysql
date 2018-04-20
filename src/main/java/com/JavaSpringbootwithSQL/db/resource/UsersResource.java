package com.JavaSpringbootwithSQL.db.resource;

import com.JavaSpringbootwithSQL.db.model.Users;
import com.JavaSpringbootwithSQL.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/signup")
    public List<Users> persist(@RequestBody final Users users) {
        usersRepository.save(users);
        return usersRepository.findAll();
    }

    @GetMapping(value = "/getUsers/{userName}")
    public String getUser(@PathVariable String userName){
        List<Users> AllUsers = usersRepository.findAll();
        for(Users user:AllUsers){
            if (user.getUsername().equals(userName)){
                return user.getPassword();
            }
        }
        return "sorry user not found";

    }

}
