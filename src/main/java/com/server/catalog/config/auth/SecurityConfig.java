package com.server.catalog.config.auth;

import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig  {
	
	
    
	@Bean
	JwtAuthenticationConverter authenticationConverter(
	      Converter<Map<String, Object>, Collection<GrantedAuthority>> authoritiesConverter) {
	  var authenticationConverter = new JwtAuthenticationConverter();
	  authenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
	    return authoritiesConverter.convert(jwt.getClaims());
	  });
	  return authenticationConverter;
	}
	
	@Bean
	SecurityFilterChain resourceServerSecurityFilterChain(
	      HttpSecurity http,
	      Converter<org.springframework.security.oauth2.jwt.Jwt, ? extends AbstractAuthenticationToken> authenticationConverter) throws Exception {
	  
		http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
		
		http.oauth2ResourceServer(resourceServer -> {
	    resourceServer.jwt(jwtDecoder -> {
	      jwtDecoder.jwtAuthenticationConverter(authenticationConverter);
	    });
	  });

	  http.sessionManagement(sessions -> {
	    sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }).csrf(csrf -> {
	    csrf.disable();
	  });

	  http.authorizeHttpRequests(requests -> {
	    requests.requestMatchers("/api/company").authenticated();
	    requests.anyRequest().denyAll();
	  });

	  return http.build();
	}

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:4200");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}


