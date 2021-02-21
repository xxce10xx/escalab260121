package com.cgbh.microservices.security.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class InfoAdicionalToken implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("curso", "Microservicios");
		info.put("profesor", "Cedric");
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}
