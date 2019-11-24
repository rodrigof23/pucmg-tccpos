package com.controlevendas.controlevendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.controlevendas.controlevendas.model.Produto;

@Repository
public interface ProdutoDao extends CrudRepository<Produto, Long> {
	
	Produto findByNrCodigo(Long nrCodigo);

}
