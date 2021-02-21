package com.cgbh.microservices.security.config;

import java.util.Arrays;
import java.util.Collections;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("userDetailsServiceBean")
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(env.getProperty("config.security.oauth.client.id"))
				.secret(passwordEncoder.encode(env.getProperty("config.security.oauth.client.secret")))
				.scopes("read", "write").authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(600).refreshTokenValiditySeconds(1000)

				.and().withClient("app_admin").secret(passwordEncoder.encode("elsecreto")).scopes("write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(600)
				.refreshTokenValiditySeconds(1000);
	
	}

	//Use for Clients in database
	
//	@Override public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.jdbc(dataSource()).passwordEncoder(passwordEncoder()); 
//	 }

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()") // url:/oauth/token_key
				.checkTokenAccess("isAuthenticated()"); // url:/oauth/check_token allow check token
				//.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		/*tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken(), accessTokenConverter()));

		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				 .accessTokenConverter(accessTokenConverter())
				 .userDetailsService(userDetailsService)
				 .tokenEnhancer(tokenEnhancerChain)
				 .approvalStoreDisabled();*/
		
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
	    enhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter()));
	    endpoints.tokenStore(tokenStore())
	            .accessTokenConverter(accessTokenConverter())
	            .tokenEnhancer(enhancerChain)
	            .reuseRefreshTokens(true)  // <-------------- Set to false
	            .authenticationManager(authenticationManager)
	            .userDetailsService(userDetailsService);
		
		
		/*
		 * endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore(
		 * )) .accessTokenConverter(accessTokenConverter());
		 */
	}

//	Tokens in Memory	
//	@Bean public JwtTokenStore tokenStore() { 
//		return new JwtTokenStore(accessTokenConverter()); 
//	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setAuthenticationManager(authenticationManager);
		defaultTokenServices.setTokenEnhancer(infoAdicionalToken());
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setReuseRefreshToken(true);
		return defaultTokenServices;
	}

	@Bean
	public TokenEnhancer infoAdicionalToken() {
		return new InfoAdicionalToken();
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(env.getProperty("config.security.oauth.jwt.key"));
		return tokenConverter;
	}

	/* Population Database only developer action
	 * 
	 * @Value("classpath:schema.sql") private Resource schemaScript;
	 * 
	 * @Value("classpath:data.sql") private Resource dataScript;
	 */
	/*
	 * private DatabasePopulator databasePopulator() { final
	 * ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	 * populator.addScript(schemaScript); populator.addScript(dataScript); return
	 * populator; }
	 */
	/*
	 * @Bean public DataSourceInitializer dataSourceInitializer(final DataSource
	 * dataSource) { final DataSourceInitializer initializer = new
	 * DataSourceInitializer(); initializer.setDataSource(dataSource);
	 * initializer.setDatabasePopulator(databasePopulator()); return initializer; }
	 */
}
