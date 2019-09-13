package com.gerenciadorapp.gerenciadorapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.gerenciadorapp.gerenciadorapp.model.ArquivoModel;

public interface ArquivoRepository extends CrudRepository<ArquivoModel,String>{
	ArquivoModel findById(long id);
	
	void deleteById(long id);
}
