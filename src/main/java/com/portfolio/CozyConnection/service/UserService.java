package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import org.springframework.stereotype.Service;


public interface UserService {
    String save(User user);
}
