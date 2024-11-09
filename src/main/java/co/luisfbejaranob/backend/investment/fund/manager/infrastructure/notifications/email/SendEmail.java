package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.notifications.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendEmail
{
    @Value("${notification.email.smtp.auth}")
    private String smtpAuth;

    @Value("${notification.email.smtp.starttls.enable}")
    private String smtpStarttlsEnable;

    @Value("${notification.email.host}")
    private String host;

    @Value("${notification.email.port}")
    private String port;

    @Value("${notification.email.username}")
    private String username;

    @Value("${notification.email.password}")
    private String password;

    @Value("${notification.email.from}")
    private String from;

    public void execute(String email, String fundName)
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", smtpStarttlsEnable);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Subscription to the fund: %s".formatted(fundName));
            message.setText("Your subscription to the fund: %s has been successful".formatted(fundName));
            Transport.send(message);
            System.out.println("Email sent successfully...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
