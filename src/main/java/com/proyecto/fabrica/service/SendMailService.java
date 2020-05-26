package com.proyecto.fabrica.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {



    @Autowired
    private JavaMailSender javaMailSender;



    public void sendMail(String from, String to, String subject, String body) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);


        //javaMailSender.send(mail);
        
        MimeMessage message = javaMailSender.createMimeMessage();
        String cc = "";
        cc = "Archivo; De ; Prueba;";
        
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            helper.addAttachment("MyTestFile.csv", new ByteArrayResource(cc.getBytes()));
            javaMailSender.send(message);
        } catch (MessagingException e) {

        }


    }


}