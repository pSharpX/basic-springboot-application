/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.service.aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.springboot.utils.SoporteCache;

/**
 *
 * @author Java-LM
 */
@Aspect
@Component
public class CachingAspect {
    
    private Map<String, Object> cache = new ConcurrentHashMap<>();
    
    @Around("execution(* pe.edu.cibertec.springboot..SoporteCache.obtener*(..))")
    public Object manejoCache(ProceedingJoinPoint pjp) throws Throwable{
        SoporteCache soporteCache = (SoporteCache)pjp.getThis();
        String identificador = soporteCache.getIdentificador();
        Object result = cache.get(identificador);
        if(result == null){            
            result = pjp.proceed();
            cache.put(identificador, result);
        }
        return result;
    }
}
