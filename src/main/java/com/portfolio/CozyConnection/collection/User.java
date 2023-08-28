package com.portfolio.CozyConnection.collection;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "users") // collection name for mongodb
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
@Id
    private String userId;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;

    private List<Game> favoriteGames;
    private List<Friend> friends;

}
