package com.bardalez.microzuul.fallbacks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

import com.bardalez.microzuul.models.ResponseError;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
@Configuration
public class MyFallbackProvider implements FallbackProvider {

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON);
				return header;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				String msj = "Error procesando su solicitud, intentelo mas tarde";
				ResponseError re = new ResponseError(msj, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(re);
				return new ByteArrayInputStream(json.getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.NOT_FOUND.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.NOT_FOUND;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.NOT_FOUND.value();
			}
			
			@Override
			public void close() {
			}
		};
	}

}*/
