/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.application.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author CHRISTIAN
 */
@Autowired
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalizedMessage {
    String value() default "";
}
