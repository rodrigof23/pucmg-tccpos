package com.controlevendas.controlevendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.controlevendas.controlevendas.model.Cartao;

@Repository
public interface CartaoDao extends CrudRepository<Cartao, Long> {

}
