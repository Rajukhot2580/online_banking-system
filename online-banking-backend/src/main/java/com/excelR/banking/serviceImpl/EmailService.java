package com.excelR.banking.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class EmailService {
    private static Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rajuskhotnds@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        log.info("mail : {} ",message);
        mailSender.send(message);
        System.out.println("Mail sent successfully...");
    }
}


//package com.excelR.banking.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendRegistrationEmail(String toEmail, String subject, String body) {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(toEmail);
//            message.setSubject(subject);
//            message.setText(body);
//            javaMailSender.send(message);
//            System.out.println("Email sent successfully.");
//        } catch (Exception e) {
//            System.err.println("Failed to send email: " + e.getMessage());
//            throw e; // Re-throw the exception to handle it appropriately
//        }
//    }
//}

