package com.portfolio.CozyConnection;


import com.portfolio.CozyConnection.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class CozyConnectionApplication {


    public static void main(String[] args) {


// TODO: Work on Validation using the @Valid annotation and spring validation api

//		User Bob = User.builder()
//				.firstname("Bob")
//				.age(24)
//				.lastname("Joseph")
//				.build();
//		userServiceImpl.save(Bob);
//		User Joe = User.builder()
//				.firstname("Joe")
//				.age(22)
//				.lastname("Joseph")
//				.build();
//		User Daina = User.builder()
//				.firstname("Daina")
//				.age(50)
//				.lastname("Joseph")
//				.build();
//		User Sherry = User.builder()
//				.firstname("Sherry")
//				.age(45)
//				.lastname("Joseph")
//				.build();
//		User Kyle = User.builder()
//				.firstname("Kyle")
//				.age(15)
//				.lastname("Joseph")
//				.build();
        SpringApplication.run(CozyConnectionApplication.class, args);


    }


}
