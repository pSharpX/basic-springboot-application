/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.service.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.validation.constraints.NotNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 *
 * @author CHRISTIAN
 */
@Aspect
@Component
public class NotNullParameterAspect {

    @Before("@within(pe.edu.cibertec.springboot.application.annotation.BusinessService)")
    public void before(JoinPoint caller) {
        Method method = getCurrentMethod(caller);

        Object[] parameters = caller.getArgs();

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        // Throw exception if a parameter value is null AND
        // at the same time declares that it must be @NotNull
        for (int i = 0; i < parameters.length; i++) {
            Object parameterValue = parameters[i];
            Annotation[] annotationsOnParameter = parameterAnnotations[i];

            if (parameterValue == null && hasNotNullAnnotation(annotationsOnParameter)) {
                String msgTemplate = String.format("Parameter at index %s must not be null", i);
                throw new IllegalArgumentException(msgTemplate);
            }
        }
    }

    private boolean hasNotNullAnnotation(Annotation... annotations) {
        return Arrays.asList(annotations).stream().
                anyMatch(a -> a.annotationType() == NotNull.class);
    }

    private Method getCurrentMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
