/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author Java-LM
 */
@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* pe.edu.cibertec.springboot.controller.*.*(..))")
    public void beforeController(JoinPoint jp){
        System.out.println("Antes de ejecutar: " 
                + jp.getSignature().getDeclaringType().getCanonicalName() + "."
                + jp.getSignature().getName());
    }
    
    @After("execution(* pe.edu.cibertec.springboot.controller.*.*(..))")
    public void afterController(JoinPoint jp){
        System.out.println("Después de ejecutar: " 
                + jp.getSignature().getDeclaringType().getCanonicalName() + "."
                + jp.getSignature().getName());
    }
}
