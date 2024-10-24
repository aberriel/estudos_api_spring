package com.sinqia.teste_api.routes;

import com.sinqia.teste_api.domain.dto.carros.CarroDTO;
import com.sinqia.teste_api.domain.services.carros.CarroService;
import com.sinqia.teste_api.models.carros.Carro;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/carros")
public class CarView {
	@Autowired
	private CarroService service;

	@GetMapping()
	public Iterable get() {
		//List<Carro> carros = service.getCarros();
		//return ResponseEntity.ok(carros);
		return service.getCarros();
	}
	
	@GetMapping("/{id}")
	public Optional<Carro> get(@PathVariable("id") Long id) {
		// Optional: quando o objeto é nulo
		/*
		Optional<CarroDTO> carro = service.getCarroById(id);
		// Internamente retorno o status 200 (OK)
		return carro.map(c -> ResponseEntity.ok(carro))
				    .orElse(ResponseEntity.notFound().build());
		*/
		return service.getCarroById(id);
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo) {
		/*
		List<CarroDTO> carros = service.getCarrosByTipo(tipo);
		return carros.isEmpty() ?
					ResponseEntity.noContent().build() :
					ResponseEntity.ok(carros);
		*/
		return service.getCarrosByTipo(tipo);
	}
	
	@PostMapping
	public String post(@RequestBody Carro carro) {
		Carro c = service.save(carro);
		return "Carro salvo com sucesso: " + c.getId();
	}
	
	/*
	@PostMapping
	public ResponseEntity post(@RequestBody Carro carro) {
		try {
			CarroDTO c = service.insert(carro);
			return c != null ?
					ResponseEntity.created(getUri(c)).build() :
					ResponseEntity.badRequest().build();
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	*/
	
	private URI getUri(CarroDTO c) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(";{id}")
				.buildAndExpand(c.getId()).toUri();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		Carro c = service.update(carro, id);
		return "Carro atualizado com sucesso: " + c.getId();
	}

	/*
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		CarroDTO c = service.update(carro, id);
		return c != null ?
				ResponseEntity.ok().build() :
				ResponseEntity.notFound().build();
	}
	*/

	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Carro deletado com sucesso";
	}

	/*
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		return service.delete(id) ?
				ResponseEntity.ok().build() :
				ResponseEntity.notFound().build();
	}
	*/
}