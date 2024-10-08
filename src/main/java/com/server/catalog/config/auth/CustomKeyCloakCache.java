package com.server.catalog.config.auth;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomKeyCloakCache extends HttpSessionRequestCache {
	
	 	@Override
	    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
	        // Сохраняем запросы только для защищённых маршрутов (те, которые требуют аутентификации)
	        if (!isPublicRequest(request)) {
	            super.saveRequest(request, response);
	        }
	    }
	
	    private boolean isPublicRequest(HttpServletRequest request) {
	        // Логика для определения публичного маршрута
	        String requestURI = request.getRequestURI();
	        return requestURI.startsWith("/api/company");  // Например, публичные маршруты начинаются с /api/company
	    }
	

}
