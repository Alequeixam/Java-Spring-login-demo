package com.alexhensan.logindemo.controller;

import com.alexhensan.logindemo.event.RegistrationEvent;
import com.alexhensan.logindemo.registration.RegistrationRequest;
import com.alexhensan.logindemo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    public RegisterController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping
    public String registerUser(RegistrationRequest request, final HttpServletRequest httpServletRequest) {
        var user = userService.registerUser(request);
        // email event
        publisher.publishEvent(new RegistrationEvent(user, applicationUrl(httpServletRequest)));
        return "Thanks for creating our account! Please check your e-mail.";
    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

    }
}
