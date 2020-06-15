package com.contact.login.logindetectionservice.multitenancy.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by dhirajsable on 5/11/20.
 */
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    public RestTemplateHeaderModifierInterceptor() {

    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String projectId = TenantContext.getCurrentTenant();
        request.getHeaders().add("X-TenantID", projectId);
        ClientHttpResponse response = execution.execute(request, body);
        response.getHeaders().add("X-TenantID", projectId);
        return response;
    }
}
