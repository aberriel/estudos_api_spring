package com.sinqia.teste_api.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexView {
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping()
	public String get() {
		return "Deu bom!!!";
	}
	
	// Eu posso ter quantos GETs eu quiser, desde que
	// estejam mapeados para URLs diferentes...
	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
}
