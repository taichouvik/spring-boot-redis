package com.my.school.utils.errors;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
    
    private MessageSource msgSource;

    @Autowired
    public ErrorMessage(MessageSource msgSource){
        this.msgSource = msgSource;
    }

    String getMessage(String key){
        return msgSource.getMessage(key, null, Locale.ENGLISH);
    }

    
    
}
