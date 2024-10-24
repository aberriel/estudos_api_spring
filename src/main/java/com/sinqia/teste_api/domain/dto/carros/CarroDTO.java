package com.sinqia.teste_api.domain.dto.carros;

import com.sinqia.teste_api.models.carros.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

// O lombok já gera getters, setters, constructors, etc
// Aqui também engloba toString e hashcode
@Data
public class CarroDTO {
	public CarroDTO(Long id, String nome, String tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	private Long id;
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }

	private String nome;
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }

	private String tipo;
	public String getTipo() { return this.tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	
	public static CarroDTO create(Carro carro) {
		// Aqui copio a model Carro para o DTO
		ModelMapper modelMapper = new ModelMapper();
		// Se os nomes dos atributos forem iguais, ele faz a conversão
		return modelMapper.map(carro,  CarroDTO.class);
	}
}