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
    public Boolean persist(@RequestBody final Users users) {
        List<Users> allUsers = usersRepository.findAll();
        for (Users user:allUsers){
            if (user.getUsername().equals(users.getUsername())){
                return false;
            }
        }
        usersRepository.save(users);

        return true;
    }

    @PostMapping(value = "login")
    public Boolean login(@RequestBody final Users users){
        List<Users> allUsers = usersRepository.findAll();
        for (Users user:allUsers){
            if (user.getUsername().equals(users.getUsername())&&user.getPassword().equals(users.getPassword())){
                return true;
            }
        }
        return false;
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
