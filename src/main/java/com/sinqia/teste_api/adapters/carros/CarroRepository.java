package com.sinqia.teste_api.adapters.carros;

import com.sinqia.teste_api.models.carros.Carro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
	Iterable<Carro> findByTipo(String tipo);
}