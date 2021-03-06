package com.example.switer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

//    @Value("${spring.mail.properties.mail.smtp.auth")
//    private String protocol;
//
//    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
//    private String debug;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();
//        properties.setProperty("spring.mail.properties.mail.smtp.auth", protocol);
//        properties.setProperty("spring.mail.properties.mail.smtp.starttls.enable", debug);

        return mailSender;
    }
}
