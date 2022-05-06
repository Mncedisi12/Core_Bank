package com.core_bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.debug","true");

        //set email credential
        emailConfig.setHost("smtp.mailtrap.io");
        emailConfig.setPort(2525);
        emailConfig.setUsername("709c9a6f20e8a7");
        emailConfig.setPassword("69e15050544da6");

        return emailConfig;

    }
}
