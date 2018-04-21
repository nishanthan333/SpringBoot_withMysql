package com.JavaSpringbootwithSQL.db.repository;

import com.JavaSpringbootwithSQL.db.model.Threads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadsRepository extends JpaRepository<Threads, Integer> {


}
//import com.JavaSpringbootwithSQL.db.model.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UsersRepository extends JpaRepository<Users, Integer> {
//
//
//}