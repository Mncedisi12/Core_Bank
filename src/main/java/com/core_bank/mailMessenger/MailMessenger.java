package com.core_bank.mailMessenger;

import com.core_bank.config.MailConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailMessenger {

    public static void htmlEmailMessenger(String from, String toMail, String subject,String body) throws MessagingException {

        JavaMailSender sender = MailConfig.getMailConfig();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message,true);

        //set Mail Properties
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body,true);

        sender.send(message);



    }
}
