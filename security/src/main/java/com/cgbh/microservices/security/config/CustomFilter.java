package com.cgbh.microservices.security.config;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;


public class CustomFilter extends // AbstractAuthenticationProcessingFilter {
		GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("HEMOS PASADO POR EL FILTRO");
		chain.doFilter(request, response);
	}

	/*
	 * public CustomFilter() { super("/oauth/check_token"); }
	 * 
	 * @Override public Authentication attemptAuthentication(HttpServletRequest
	 * request, HttpServletResponse response) throws AuthenticationException,
	 * IOException, ServletException { String header =
	 * request.getHeader("Authorization");
	 * 
	 * if (header == null || !header.startsWith("Bearer ")) { throw new
	 * AuthenticationException("No JWT token found in request headers") { private
	 * static final long serialVersionUID = 1L; }; }
	 * 
	 * String authToken = header.substring(7); JwtAuthenticationToken authRequest =
	 * new JwtAuthenticationToken(authToken);
	 * 
	 * return getAuthenticationManager().authenticate(authRequest); }
	 * 
	 * @Override protected void successfulAuthentication(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain chain, Authentication authResult)
	 * throws IOException, ServletException {
	 * super.successfulAuthentication(request, response, chain, authResult);
	 * 
	 * // As this authentication is in HTTP header, after success we need to
	 * continue // the request normally // and return the response as if the
	 * resource was not secured at all chain.doFilter(request, response); }
	 */
}
