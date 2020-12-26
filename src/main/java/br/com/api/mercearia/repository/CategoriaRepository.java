package br.com.api.mercearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.mercearia.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
