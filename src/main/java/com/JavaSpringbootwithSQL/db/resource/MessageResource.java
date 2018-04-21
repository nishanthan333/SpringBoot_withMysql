package com.JavaSpringbootwithSQL.db.resource;

import com.JavaSpringbootwithSQL.db.model.Message;
import com.JavaSpringbootwithSQL.db.model.Threads;
import com.JavaSpringbootwithSQL.db.repository.MessageRepository;
import com.JavaSpringbootwithSQL.db.repository.ThreadsRepository;
import com.JavaSpringbootwithSQL.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/thread/{threadId}")
    public List<Message> getMessagesOfThread(@PathVariable Integer threadId) {
        List<Message> threadMessage = new ArrayList<Message>();

        for (Message message:messageRepo.findAll()){
            if (message.getThreadId().equals(threadId)){
                threadMessage.add(message);
            }
        }

        return threadMessage;
    }

    @PostMapping(value = "/create")
    public List<Message> createMessage(@RequestBody final Message message){
        messageRepo.save(message);
        return messageRepo.findAll();
    }


    }
