package com.jalasoft.ocrwebservice;

import com.jalasoft.ocrwebservice.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
