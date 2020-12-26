package br.com.api.mercearia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.mercearia.domain.Categoria;
import br.com.api.mercearia.exception.RecursoNaoEncontradoException;
import br.com.api.mercearia.repository.CategoriaRepository;
import br.com.api.mercearia.service.CategoriaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categoria = categoriaService.Listar();
		return categoria;
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Categoria categoria = categoriaService.buscarPorCodigo(codigo)
;			return categoria;
		}catch (RecursoNaoEncontradoException excessao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", excessao);
		}
	}
	
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public Categoria excluir(@PathVariable Short codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
		Categoria categoriaRetorno = categoria.get();
		return categoriaRetorno;
	}

	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}
}
