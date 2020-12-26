package br.com.api.mercearia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.mercearia.domain.Categoria;
import br.com.api.mercearia.exception.RecursoNaoEncontradoException;
import br.com.api.mercearia.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = resultado.get();
		return categoria;
	}
	
	public List<Categoria> Listar(){
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}
}
