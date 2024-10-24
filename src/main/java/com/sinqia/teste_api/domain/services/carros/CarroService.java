package com.sinqia.teste_api.domain.services.carros;

import com.sinqia.teste_api.adapters.carros.CarroRepository;
import com.sinqia.teste_api.domain.dto.carros.CarroDTO;
import com.sinqia.teste_api.models.carros.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

// Aqui eu defino este service como um bean gerenciado pelo Spring
@Service
public class CarroService {
	@Autowired
	private CarroRepository rep;
	
	public Iterable<Carro> getCarros() {
		return rep.findAll();
	}
	
	/**
	 * Retorna uma lista de carros fake
	 * @return Lista de carros
	 */
	public List<Carro> getCarrosFake() {
		//List<CarroDTO> list = rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
		// Temporário (enquanto não usarmos o banco)
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L, "Fusca"));
		carros.add(new Carro(2L, "Brasília"));
		carros.add(new Carro(3L, "Chevete"));
		
		//return list;
		return carros;
	}
	
	/**
	 * Busca um carro específico
	 * @param id ID do carro a ser buscado
	 * @return Dados do carro encontrado
	 */
	public Optional<Carro> getCarroById(Long id) {
		//Optional<Carro> carro = rep.findById(id);
		//return carro.map(CarroDTO::create);
		return rep.findById(id);
	}
	
	public Iterable<Carro> getCarrosByTipo(String tipo) {
		//return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
		return rep.findByTipo(tipo);
	}
	
	public Carro save(Carro carro) {
		return rep.save(carro);
	}
	
	public CarroDTO insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
		return CarroDTO.create(rep.save(carro));
	}
	
	public Carro update(Carro carro, Long id) {
		// Aqui valido se recebi o ID
		Assert.notNull(id, "Não foi possível atualizar o registro");
		
		// Aqui valido se o carro com ID fornecido existe
		Optional<Carro> optional = getCarroById(id);
		if (optional.isPresent()) {
			// Vai que o ID não existe...
			Carro db = optional.get();
			// Sobrescrevendo nome e tipo
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());
			// Atualizando o carro no banco
			rep.save(db);
			return db;
		}
		else {
			// Neste caso o carro não existe
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
		
		/*
		getCarroById(id).map(db -> {
			// Copiar as propriedades
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());
			// Atualizando o carro
			rep.save(db);
			return db;
		}).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));
		*/
	}
	
	/*
	public CarroDTO update(Carro carro, Long id) {
		Assert.notNull(id,  "Não foi possível atualizar o registro");
		
		// Busco o carro no banco de dados
		Optional<Carro> optional = rep.findById(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			// Copiar as propriedades
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro ID: " + db.getId());
			
			// Atualiza o carro
			rep.save(db);
			return CarroDTO.create(db);
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o registro");
			// eu posso gerar um NotFound retornando null
			// return null;
		}
	}
	*/
	
	public void delete(Long id) {
		Optional<Carro> carro = getCarroById(id);
		if(carro.isPresent()) {
			rep.deleteById(id);
		}
	}
	
	/*
	public boolean delete(Long id) {
		return getCarroById(id).map(c -> {
			rep.deleteById(id);
			return true;
		}).orElse(false);
	}
	*/
}