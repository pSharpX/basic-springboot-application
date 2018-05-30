/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Java-LM
 */
@SpringBootApplication(scanBasePackages = "pe.edu.cibertec.springboot")
@EnableAspectJAutoProxy
@PropertySource("classpath:database.properties")
public class MainApplication {
    
    
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
