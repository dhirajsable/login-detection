package com.contact.login.logindetectionservice.service;

import com.contact.login.logindetectionservice.entity.DeviceMetadata;
import com.contact.login.logindetectionservice.entity.DeviceMetadataRepository;
import com.google.common.base.Strings;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
public class DeviceMetadataServiceImpl implements DeviceMetadataService {

    private static final String UNKNOWN = "UNKNOWN";

    @Autowired
    private DatabaseReader databaseReader;

    @Autowired
    private Parser parser;

    @Autowired
    DeviceMetadataRepository metadataRepository;

    @Override
    public String addDeviceMetadata(HttpServletRequest request) throws IOException, GeoIp2Exception {
        String ip = extractIp(request);
        String location = getIpLocation(ip);
        String deviceDetails = getDeviceDetails(request.getHeader("user-agent"));

        long userId = 100;
        DeviceMetadata deviceMetadata = new DeviceMetadata();
        deviceMetadata.setUserId(userId);
        deviceMetadata.setLocation(location);
        deviceMetadata.setDeviceDetails(deviceDetails);
        metadataRepository.save(deviceMetadata);
        return deviceDetails;
    }

    private String extractIp(HttpServletRequest request) {
        String clientIp;
        String clientXForwardedForIp = request.getHeader("x-forwarded-for");
        if (nonNull(clientXForwardedForIp)) {
            clientIp = parseXForwardedHeader(clientXForwardedForIp);
        } else {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }

    private String getIpLocation(String ip) throws IOException, GeoIp2Exception {
        String location = UNKNOWN;
        InetAddress ipAddress = InetAddress.getByName(ip);
        try {
            CityResponse cityResponse = databaseReader.city(ipAddress);
            if (Objects.nonNull(cityResponse) &&
                    Objects.nonNull(cityResponse.getCity()) &&
                    !Strings.isNullOrEmpty(cityResponse.getCity().getName())) {

                location = cityResponse.getCity().getName();
            }
        } catch (Exception ex) {
            /**
             * TODO Add logs here.
             */
        }
        return location;
    }

    private String getDeviceDetails(String userAgent) {
        String deviceDetails = UNKNOWN;
        Client client = parser.parse(userAgent);
        if (Objects.nonNull(client)) {
            deviceDetails = client.userAgent.family + " " + client.userAgent.major + "." + client.userAgent.minor +
                    " - " + client.os.family + " " + client.os.major + "." + client.os.minor;
        }
        return deviceDetails;
    }


}
