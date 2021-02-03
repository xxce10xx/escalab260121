package com.bardalez.microcesta.controller;

//import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.microcesta.client.EurekaClient;
import com.bardalez.microcesta.model.Cesta;
import com.bardalez.microcesta.model.Producto;
import com.bardalez.microcesta.repository.CestaRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@CrossOrigin(origins = "*")
public class CestaController {

	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CestaRepository cestaRepository;
	
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
	public Producto getProducto(@PathVariable String codigo)
	{
		//URI catalogoURI = eureka.getUri("SERVICIO.CATALOGO");
		//Producto prod = restTemplate.getForObject(catalogoURI.resolve("/producto/"+codigo), Producto.class);
		Producto prod = restTemplate.getForObject("http://SERVICIO.CATALOGO/producto/"+codigo, Producto.class);
		return prod;
	}
	
	@HystrixCommand(fallbackMethod = "fallbackMethod2")
	private Producto fallbackMethod(String codigo) {
		System.out.println("*************************FALLE DE NUEVO*********************************");
		Producto prod = restTemplate.getForObject("http://SERVICIO.CATALOGO/producto/"+codigo, Producto.class);
		return prod;
		//return new Producto("0","Articulo de prueba","prueba",1, 38.5, "dasdasd");
	}
	
	private Producto fallbackMethod2(String codigo) {
		return new Producto("0","Articulo de prueba","prueba",1, 38.5, "dasdasd");
	}
}
