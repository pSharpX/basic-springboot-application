/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.application.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.stereotype.Component;

/**
 *
 * @author CHRISTIAN
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessService {
    
}
