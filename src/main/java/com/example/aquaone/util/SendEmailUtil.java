package com.example.aquaone.util;

import com.example.aquaone.to.ProductTo;
import com.example.aquaone.to.UserTo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailUtil {
    private void  send(String messageToSend){
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Recipient's email ID needs to be mentioned.
        String actualMessage = messageToSend;
        String to = "aron86@list.ru";

        // Sender's email ID needs to be mentioned
        String from = "orders.aquaone@gmail.com";

        // Get system properties
        Properties props = System.getProperties();

        // Setup mail server
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "orders.aquaone@gmail.com";//
        final String password = "123edc456";

        // Get the default Session object.
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setSentDate(new Date());

            // Set Subject: header field
            message.setSubject("Заказ воды");
            message.setText(actualMessage);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public void createAndSendMessage(UserTo user, ProductTo[] products, String comment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + user.getUsername() + " Фамилия " + user.getSurname() + " Организация " + user.getOrganization() + "\n");
        stringBuilder.append("Телефон " + user.getPhone() + " Почта " + user.getEmail() + " Адрес " + user.getAddress() + "\n");
        int count = 0;
        for (ProductTo p: products) {
            stringBuilder.append("Название товара: " + p.getName() + " Количество " + p.getCount() +" шт. " + " Сумма: " + p.getSubprice() + "\n");
            count += p.getSubprice();
        }
        stringBuilder.append("Комментарий к заказу " + comment + "\n");
        stringBuilder.append("Общая сумма: " + count);
        send(stringBuilder.toString());

    }
    public void createAndSendMessage(String name, String email, String text){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Пользователь с именем " + name + " и почтой " + email + "\n");
        stringBuilder.append("Написал: " + text);
        send(stringBuilder.toString());

    }
}
