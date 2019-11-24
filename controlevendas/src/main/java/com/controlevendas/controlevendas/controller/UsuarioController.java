package com.controlevendas.controlevendas.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controlevendas.controlevendas.model.Usuario;
import com.controlevendas.controlevendas.service.UsuarioService;
import com.controlevendas.controlevendas.util.ResponseUtil;

@Controller
@RequestMapping(path="/usuario")
public class UsuarioController {
	
	private static final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Rota responsavel por realizar a autenticacao do usuario
	 * 
	 * @param email E-mail do usuario
	 * @param senha Senha do usuario
	 * @return Usuario autenticado
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	@GetMapping(path="/autenticar")
	@ResponseBody
	public Object autenticar(@RequestParam String email, @RequestParam String senha) {
		try {
			return ResponseEntity.ok(this.usuarioService.retornaUsuario(email, senha));
		} catch (Exception e) {
			log.error("Erro na requisição /autenticar.", e);
			return ResponseUtil.returnException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	/**
	 * Rota responsavel por realizar a autorizacao do usuario
	 * 
	 * @param userId ID do usuario
	 * @return Usuario autorizado
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	@GetMapping(path="/autorizar")
	@ResponseBody
	public Object autorizar(@RequestAttribute Usuario usuario) {
		try {
			return ResponseEntity.ok(this.usuarioService.retornaUsuario(usuario.getIdUsuario()));
		} catch (Exception e) {
			log.error("Erro na requisição /autorizar.", e);
			return ResponseUtil.returnException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
