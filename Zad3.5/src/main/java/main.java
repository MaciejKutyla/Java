package main.java;

import main.java.EmailMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import javax.activation.*;
import java.util.*;

public class main {
    public static void main(String[] argv) throws IOException{
        EmailMessage.Builder wiadomosc = EmailMessage.builder();
        wiadomosc.addFrom("maciejo117@gmail.com");
        wiadomosc.addTo("maciejo117@gmail.com");
        wiadomosc.addContent("Kocham robic jave w piatkowe wieczory");
        EmailMessage wiad=wiadomosc.build();
        System.out.print(wiad.getFrom());


        final String username = "maciejo117@gmail.com";
        final String password = "123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

           }
}