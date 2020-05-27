package com.proyecto.fabrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {



    @Autowired
    private JavaMailSender javaMailSender;



    public void sendMail(String from, String to, String subject, String body,List<Pedidos> pedidos) throws IOException {
        
        MimeMessage message = javaMailSender.createMimeMessage();

        ByteArrayInputStream in = ExcelGenerator.customersToExcel(pedidos);
        
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            helper.addAttachment("Pedidos.xlsx", new ByteArrayResource(in.readAllBytes()));
            javaMailSender.send(message);
        } catch (MessagingException e) {

        }


    }


}