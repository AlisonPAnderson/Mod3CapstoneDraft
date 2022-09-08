package com.techelevator;

import com.techelevator.business.UserService;
import com.techelevator.model.User;
import com.techelevator.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.techelevator")
public class Application {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);


    }
}