/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.service.Impl;

import com.manu.securedoc.exception.ApiException;
import com.manu.securedoc.service.EmailService;
import com.manu.securedoc.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private static final String PASSWORD_RESET_REQUEST = "Password Reset Request";
    private final JavaMailSender sender;

    @Value("${spring.mail.verify.host}")
    private String host;

    @Value("${SPRING.MAIL.USERNAME")
    private String fromEmail;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    @Async
    public void sendNewAccountEmail(String name, String email, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(emailUtils.getEmailMessage(name,host,token));
            sender.send(message);
        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new ApiException("Unable to send email");
        }
    }

    @Override
    @Async
    public void sendPasswordResetEmail(String name, String email, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESET_REQUEST);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(emailUtils.getResetPasswordMessage(name,host,token));
            sender.send(message);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Unable to send email");
        }
    }
}
