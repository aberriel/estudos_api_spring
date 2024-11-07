package com.sinqia.teste_api.routes;

import com.sinqia.teste_api.domain.dto.carros.CarroDTO;
import com.sinqia.teste_api.domain.services.carros.CarroService;
import com.sinqia.teste_api.models.carros.Carro;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/carros")
public class CarView {
	@Autowired
	private CarroService service;

	@GetMapping()
	public ResponseEntity<Iterable<Carro>> get() {
		return ResponseEntity.ok(service.getCarros());
		// Abaixo uma forma alternativa de fazer o acima
		// return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		// Optional: quando o objeto é nulo
		Optional<Carro> carro = service.getCarroById(id);

		// Formato com IF-ELSE
		/*
		if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		*/

		// Formato com ternário
		return carro.isPresent() ?
				ResponseEntity.ok(carro.get()) :
				ResponseEntity.notFound().build();
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
		List<Carro> carros = (List<Carro>) service.getCarrosByTipo(tipo);
		return carros.isEmpty() ?
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(carros);
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