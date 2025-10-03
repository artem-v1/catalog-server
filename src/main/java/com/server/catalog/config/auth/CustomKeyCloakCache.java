//package com.server.catalog.config.auth;
//
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class CustomKeyCloakCache extends HttpSessionRequestCache {
//	
//	 	@Override
//	    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
//	        // save into the cache only auth requests and responses 
//	        if (!isPublicRequest(request)) {
//	        	System.out.print("сработал бин кеширования");
//	            super.saveRequest(request, response);
//	        }
//	    }
//	
//	    private boolean isPublicRequest(HttpServletRequest request) {
//	        // wright url for public request
//	        String requestURI = request.getRequestURI();
//	        return requestURI.startsWith("/api/company");  // Например, публичные маршруты начинаются с /api/company
//	    }
//	
//
//}
