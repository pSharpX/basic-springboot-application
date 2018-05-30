/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.utils;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 *
 * @author CHRISTIAN
 */
public class Message {

    private final MessageSource messageSource;

    private final String messageKey;

    public Message(MessageSource messageSource, String messageKey) {
        this.messageSource = messageSource;
        this.messageKey = messageKey;
    }

    public String format(Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageKey, args, locale);
    }
}
