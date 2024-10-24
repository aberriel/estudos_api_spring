package com.sinqia.teste_api.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/uber/guest")
public class UberGuestView {
	@GetMapping()
	public String get() {
		return "API de passageiros da Uber";
	}
}
