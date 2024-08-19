package edu.icet.crm.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      //This annotation use fore convert to SpringBoot Application
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);       //This line use for hand over to framework
    }
}
