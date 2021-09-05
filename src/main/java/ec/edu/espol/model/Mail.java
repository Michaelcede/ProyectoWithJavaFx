/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author micha
 */
public class Mail {
   
    

    public static void sendMail(String correo) {
        String Username = "BestproyectoPoo@gmail.com";
        String PassWord = "ProyectoPoo2021";
        String asunto = "CREACION DE CUENTA";
        Properties pros = System.getProperties();
        pros.put ("mail.smtp.host", "smtp.gmail.com"); 
        pros.put ("mail.smtp.port", "587"); 
        pros.put ("mail.smtp.starttls.enable", "true"); 
        pros.put ("mail.smtp.auth", "true"); 
        
        Session session = Session.getInstance(pros,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject(asunto);
            message.setText("Su Registro ha sido Exitoso!!");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    

}

