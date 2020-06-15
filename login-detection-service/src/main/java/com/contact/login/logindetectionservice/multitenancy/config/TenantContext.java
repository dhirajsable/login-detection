package com.contact.login.logindetectionservice.multitenancy.config;

/**
 * Created by dhirajsable on 5/11/20.
 */
public class TenantContext {

    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
}
