package com.controlevendas.controlevendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.controlevendas.controlevendas.model.Pedido;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Long> {

}
