/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.event.listner;

import com.manu.securedoc.event.UserEvent;
import com.manu.securedoc.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserEventListener {
    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent event){
        switch (event.getType()) {
            case REGISTRATION -> {
                emailService.sendNewAccountEmail(
                        event.getUser().getFirstName(),
                        event.getUser().getEmail(),
                        (String) event.getData().get("key"));
                log.info("Email sent for registration");
            }
            case RESETPASSWORD -> emailService.sendPasswordResetEmail(
                    event.getUser().getFirstName(),
                    event.getUser().getEmail(),
                    (String) event.getData().get("key"));
            default -> log.error("Didn't found valid type while sending the notification {}", event.getType());
        }
    }
}
