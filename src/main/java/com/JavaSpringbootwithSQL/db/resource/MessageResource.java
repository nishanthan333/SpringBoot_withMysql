package com.JavaSpringbootwithSQL.db.resource;

import com.JavaSpringbootwithSQL.db.model.Message;
import com.JavaSpringbootwithSQL.db.model.Threads;
import com.JavaSpringbootwithSQL.db.repository.MessageRepository;
import com.JavaSpringbootwithSQL.db.repository.ThreadsRepository;
import com.JavaSpringbootwithSQL.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ThreadsRepository threadRepo;

    @Autowired
    MessageRepository messageRepo;

    @GetMapping(value = "/all")
    public List<Message> getAll() {
        return messageRepo.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<Message> getUserMessages(@PathVariable Integer userId){

        List<Message> userMessages = new ArrayList<Message>();

        for(Message message:messageRepo.findAll()){
            if (message.getUserId().equals(userId)){
                userMessages.add(message);
            }
        }

        return userMessages;
    }



}
