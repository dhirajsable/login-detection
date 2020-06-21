package com.contact.login.logindetectionservice.rest;

import com.contact.login.logindetectionservice.service.DeviceMetadataService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/detection")
public class LoginDetectionController {

    @Autowired
    DeviceMetadataService metadataService;

    @RequestMapping(
            value = "/ping",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(HttpServletRequest request) throws IOException, GeoIp2Exception {
        String message = metadataService.addDeviceMetadata(request);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}