package com.JavaSpringbootwithSQL.db.repository;

import com.JavaSpringbootwithSQL.db.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
