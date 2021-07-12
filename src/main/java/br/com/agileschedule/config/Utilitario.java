package br.com.agileschedule.config;

import javax.servlet.http.HttpServletRequest;

public class Utilitario {
    public static String getUrlSite(HttpServletRequest request) {
        
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
    }
}
