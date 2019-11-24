package com.controlevendas.controlevendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.controlevendas.controlevendas.model.Endereco;

@Repository
public interface EnderecoDao extends CrudRepository<Endereco, Long> {

}
