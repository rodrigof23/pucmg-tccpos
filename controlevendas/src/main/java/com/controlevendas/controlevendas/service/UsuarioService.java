package com.controlevendas.controlevendas.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlevendas.controlevendas.dao.UsuarioDao;
import com.controlevendas.controlevendas.model.Usuario;

@Service
public class UsuarioService {
	
	private static final Logger log = LogManager.getLogger(UsuarioService.class);

	@Autowired
    private UsuarioDao usuarioDao;
	
	/**
	 * Metodo responsavel por buscar um usuario por e-maill e senha
	 * 
	 * @param email E-mail do usuario
	 * @param senha Senha do usuario
	 * @return usuario encontrado
	 * 
	 * @Rodrigo de Freitas Santos
	 */
	public Usuario retornaUsuario(String email, String senha) {
		Usuario usuario = usuarioDao.findByNmEmailAndNmSenha(email, senha);
		log.info("Usuário autenticado: " + usuario.getNmEmail());
		
		return usuario;
	}
	
	/**
	 * Metodo responsavel por buscar um usuario pelo ID
	 * 
	 * @param usuarioId ID do usuario
	 * @return usuario encontrado
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	public Usuario retornaUsuario(Long usuarioId) {
		Optional<Usuario> usuario = usuarioDao.findById(usuarioId);
		if (usuario.isPresent()) {
			log.info("Usuário autorizado: " + usuario.get().getNmEmail());
			
			return usuario.get();
		}
		return null;
	}

}
