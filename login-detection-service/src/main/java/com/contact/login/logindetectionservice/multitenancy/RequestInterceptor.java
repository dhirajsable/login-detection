package com.contact.login.logindetectionservice.multitenancy;

import com.contact.login.logindetectionservice.multitenancy.config.TenantContext;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dhirajsable on 5/11/20.
 */
@Service
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final String DEFAULT_SCHEMA_TENANT = "contactlogin";
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        System.out.println("In preHandle we are Intercepting the Request");
        System.out.println("____________________________________________");
        String requestURI = request.getRequestURI();
        String tenantID = request.getHeader("X-TenantID");
        System.out.println("RequestURI::" + requestURI + " || Search for X-TenantID  :: " + tenantID);
        System.out.println("____________________________________________");
        if (tenantID == null) {
            /*
             * ADD A CHECK FOR API URL
             */
            TenantContext.setCurrentTenant(DEFAULT_SCHEMA_TENANT);
//            response.getWriter().write("X-TenantID not present in the Request Header");
//            response.setStatus(400);
            return true;
        }
        TenantContext.setCurrentTenant(tenantID);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
    }
}
