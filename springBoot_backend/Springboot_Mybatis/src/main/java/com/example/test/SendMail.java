package com.example.test;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendMail {


    // Sender's email and password (replace with your own email and password)
    //     For mailboxes with a separate password enabled, this separate password (authorization code) must be used for the mailbox password here.
    public static String myEmailAccount = "tangwang_2021@qq.com";
    public static String myEmailPassword = "xycmhwwfevefceaf";


    //The SMTP server address of qq mailbox is: smtp.126.com
    public static String myEmailSMTPHost = "smtp.qq.com";

    // Recipient Email
    public static String receiveMailAccount = "18512542995@163.com";

    public static void main(String[] args) throws Exception {


        // Create parameter configurations for connecting to the mail server
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        // 2. Create session objects based on the configuration for interaction with the mail server
        Session session = Session.getInstance(properties);
        // Set to debug mode, you can see the detailed send log
        session.setDebug(true);

        // 3.  create  a email
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);

        // 4. get email Transmission object from Session
        Transport transport = session.getTransport();

        // 5. Use the mailbox account and password to connect to the mail server, the authentication mailbox must match the sender mailbox in the message, otherwise an error is reported
        //
        // PS_01: If the connection to the server fails, a log will be output in the console with the corresponding failure reason.
        // Check the reason for failure carefully, some mailbox servers will return an error code or a link to view the error type,
        // Check the specific failure reason on the help site of the corresponding mail server according to the error type given.
        //
        // PS_02: The reasons for connection failure are usually the following, check the code carefully:
        // (1) The mailbox is not enabled for SMTP service;
        // (2) Incorrect mailbox password, e.g. some mailboxes have a separate password;
        // (3) The mailbox server requires a secure SSL connection;
        // (4) The mailbox server has denied service due to too many requests or other reasons;
        // (5) If all of the above are correct, go to the mail server website for help.
        //
        transport.connect(myEmailAccount, myEmailPassword);

        // 6. Send a message to all recipients, message.getAllRecipients() gets all the recipients, cc's, and cc's that were added when the message object was created.
        transport.sendMessage(message, message.getAllRecipients());

        // 7. close connection
        transport.close();
    }

    /**
     * Create a simple email containing only text
     *
     * @param session The session to interact with the server
     * @param sendMail The sender's mailbox
     * @param receiveMail Recipient mailbox
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {

        // 1. create a email
        MimeMessage message = new MimeMessage(session);

        // 2. From:
        message.setFrom(new InternetAddress(sendMail, "nickname", "UTF-8"));

        // 3. To:
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX user", "UTF-8"));

        // 4. Subject
        message.setSubject("subject", "UTF-8");

        // 5. Content
        message.setContent("email Content", "text/html;charset=UTF-8");

        // 6. set send time
        message.setSentDate(new Date());

        // 7. save configuration
        message.saveChanges();

        return message;
    }
}

