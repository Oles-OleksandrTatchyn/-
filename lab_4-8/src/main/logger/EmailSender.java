//package logger;
//
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailSender {
//    private static final String FROM_EMAIL = "emailsender12341@gmail.com";
//    private static final String PASSWORD = "pjrn qmdg upmm kewl";
//    private static final String TO_EMAIL = "oles2709@gmail.com";
//
//    public static void sendCriticalErrorEmail(String subject, String message) {
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            MimeMessage mimeMessage = new MimeMessage(session);
//            mimeMessage.setFrom(new InternetAddress(FROM_EMAIL));
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_EMAIL));
//            mimeMessage.setSubject(subject);
//            mimeMessage.setText(message);
//
//            Transport transport = session.getTransport("smtp");
//            transport.connect("smtp.gmail.com", FROM_EMAIL, PASSWORD);
//            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
//            transport.close();
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//}


package logger;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    private static final String FROM_EMAIL = "evil288235@gmail.com";
    private static final String PASSWORD = "gopo xuaf ghza mnac";
    private static final String TO_EMAIL = "oles2709@gmail.com";

    public static void sendCriticalErrorEmail(String subject, String message) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(FROM_EMAIL));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_EMAIL));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
