/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.application;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.AnnotationUtils;
import pe.edu.cibertec.springboot.application.annotation.LocalizedMessage;
import pe.edu.cibertec.springboot.utils.Message;

/**
 *
 * @author CHRISTIAN
 */
@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Message message(InjectionPoint ip) {
        LocalizedMessage localizedMessage = AnnotationUtils
                .getAnnotation(ip.getAnnotatedElement(), LocalizedMessage.class);

        String resourceBundleKey = localizedMessage.value();
        return new Message(messageSource(), resourceBundleKey);
    }
}
