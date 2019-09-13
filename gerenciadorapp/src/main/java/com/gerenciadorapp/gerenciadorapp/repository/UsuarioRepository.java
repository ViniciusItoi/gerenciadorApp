package com.gerenciadorapp.gerenciadorapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.gerenciadorapp.gerenciadorapp.model.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, String> {
	UsuarioModel findById(long id);
	void deleteById(long id);
}
