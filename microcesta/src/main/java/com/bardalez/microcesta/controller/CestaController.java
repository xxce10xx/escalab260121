package com.bardalez.microcesta.controller;

//import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.microcesta.client.EurekaClient;
import com.bardalez.microcesta.model.Cesta;
import com.bardalez.microcesta.model.Producto;
import com.bardalez.microcesta.repository.CestaRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import brave.Tracer;

@RestController
@CrossOrigin(origins = "*")
public class CestaController {

	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CestaRepository cestaRepository;
	
//	@Autowired
//	private Tracer tracer;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@RequestMapping(value = "/cesta/{unidades}", method = RequestMethod.POST)
	public void addProductoCesta(@RequestBody Producto prod, @PathVariable Integer unidades)
	{
		Cesta cestaTemp = new Cesta();
		cestaTemp.setNombreProducto(prod.getNombre());
		cestaTemp.setMarca(prod.getMarca());
		cestaTemp.setPrecioUnitario(prod.getPrecioUnitario());
		cestaTemp.setUnidades(unidades);
		cestaTemp.setPrecioTotal(prod.getPrecioUnitario()*unidades);
		
		cestaTemp.setUsername("Carlos"); //lo debo traer del microservicio login
		
		cestaRepository.save(cestaTemp);
		
	}
	
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	@GetMapping("/producto/{codigo}")
	public Producto getProducto(@PathVariable String codigo, @RequestHeader("Authorization") String auth)
	{
		//URI catalogoURI = eureka.getUri("SERVICIO.CATALOGO");
		//Producto prod = restTemplate.getForObject(catalogoURI.resolve("/producto/"+codigo), Producto.class);
		//Producto prod = restTemplate.getForObject("http://SERVICIO.CATALOGO/producto/"+codigo, Producto.class);
		
		/*************************************************/
		//Encabezado de Authentication
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",auth);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		//Conexion HTTP enviando encabezado
	
		ResponseEntity<Producto> resp = restTemplate.exchange("http://SERVICIO.CATALOGO/producto/"+codigo, 
																HttpMethod.GET, entity, Producto.class);
		
		//Recuperamos el producto a partir del cuerpo de la respuesta
		return resp.getBody();
	}
	
	private Producto fallbackMethod(String codigo, String auth) {
		//tracer.currentSpan().tag("error", "No esta disponible catalogo");
		return new Producto("0","Articulo de prueba","prueba",1, 38.5, "dasdasd");
	}
	
}
