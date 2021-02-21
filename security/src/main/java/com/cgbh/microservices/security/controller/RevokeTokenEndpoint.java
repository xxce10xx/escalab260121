package com.cgbh.microservices.security.controller;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

	@Resource(name = "tokenServices")
	ConsumerTokenServices tokenServices;
	
	@Resource(name = "tokenStore")
	TokenStore tokenStore;

	@DeleteMapping("/oauth/token")
	@ResponseBody
	public String revokeToken(HttpServletRequest request) {
		String tokenRevoke = request.getParameter("token_revoke"); //token to revoke
		String tokenAdmin = request.getParameter("token");
		
		if (tokenRevoke == null) {
			return "You must provide rovoke token";
		}else if (tokenAdmin == null) {
			return "You must provide authentication token";
		}else {
			OAuth2Authentication authentication = tokenStore.readAuthentication(tokenAdmin);
			
			Collection<GrantedAuthority> authorities = authentication.getAuthorities();
			
			
			if (authentication.isAuthenticated() && authorities.stream().anyMatch(auth -> auth.toString().equals("ROLE_ADMIN"))) {
				String response = tokenServices.revokeToken(tokenRevoke) ? "Success revoke process "+ tokenRevoke : "Token revoke not found in storage";
				return response;
			} else {
				return "Failed revoke process";
			}
		}
	}
}
