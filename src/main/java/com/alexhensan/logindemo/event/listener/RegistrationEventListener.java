package com.alexhensan.logindemo.event.listener;

import com.alexhensan.logindemo.event.RegistrationEvent;
import com.alexhensan.logindemo.model.User;
import com.alexhensan.logindemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationEventListener implements ApplicationListener<RegistrationEvent> {
    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        // get user
        User user = event.getUser();
        // create token for the user
        String verificationToken = UUID.randomUUID().toString();
        // save the token
        userService.saveUserVerifcationToken(verificationToken,user);
        // build the token URL to be sent to the user
        String url = event.getApplicationUrl()+"/register/confirmEmail?token="+verificationToken;
        // send the email
        log.info("Click the link to confirm our e-mail : {}", url);
    }
}
