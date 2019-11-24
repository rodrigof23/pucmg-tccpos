package com.controlevendas.controlevendas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.controlevendas.controlevendas.model.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	
	Usuario findByNmEmailAndNmSenha(String nmEmail, String nmSenha);

}
