package com.contact.login.logindetectionservice.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface DeviceMetadataService {

    String registerDevice(HttpServletRequest request) throws IOException, GeoIp2Exception;
}
