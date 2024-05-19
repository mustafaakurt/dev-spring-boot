package com.mustafaakurt.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.mustafaakurt.springcore",
                            "com.mustafaakurt.util"})
public class SpringcoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoreApplication.class, args);
    }

}
