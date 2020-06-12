package com.contact.login.logindetection.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/detection")
public class LoginDetectionController {

    @RequestMapping(
            value = "/ping",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String ping() {
        return "pong from login detection Service";
    }

}
