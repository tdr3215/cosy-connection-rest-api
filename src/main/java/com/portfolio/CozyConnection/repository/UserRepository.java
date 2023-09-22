package com.portfolio.CozyConnection.repository;

import com.portfolio.CozyConnection.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User,String> {


 List<User> findUserByAgeBetween(Integer min, Integer max);
}
