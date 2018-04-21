package com.JavaSpringbootwithSQL.db.resource;

import com.JavaSpringbootwithSQL.db.model.Threads;
import com.JavaSpringbootwithSQL.db.model.Users;
import com.JavaSpringbootwithSQL.db.repository.ThreadsRepository;
import com.JavaSpringbootwithSQL.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//     /threads/create

@RestController
@RequestMapping(value = "/threads")
public class ThreadResource {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ThreadsRepository threadRepo;

    @GetMapping(value = "/all")
    public List<Threads> getAll() {
        return threadRepo.findAll();
    }

    @GetMapping(value = "/user/threads/{username}")
    public List<Threads> getThreads(@PathVariable String username){
        List<Threads> allThreads = threadRepo.findAll();
        List<Threads> userThreads = new ArrayList<Threads>();
        for(Threads chat:allThreads){
            if (chat.getCreatedBy().equals(username)){
                userThreads.add(chat);
            }
        }
        return userThreads;

    }

    @PostMapping(value = "/create")
    public List<Threads> persist(@RequestBody final Threads threads) {
        threadRepo.save(threads);
        return threadRepo.findAll();
    }

    @PostMapping(value = "/chat")
    public List<Threads> getChats(@RequestBody final Users user){
        List<Threads> userChats = new ArrayList<Threads>();
        List<Threads> allChats= threadRepo.findAll();
        for(Threads chat:allChats){
            if (chat.getCreatedBy().equals(user.getUsername())){
                userChats.add(chat);
            }
        }

        if(userChats.get(0).toString()==null){
            return null;
        }
        else {
            return userChats;
        }
    }

}
