package com.portfolio.CozyConnection.repository;

import com.portfolio.CozyConnection.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,String> {


}
