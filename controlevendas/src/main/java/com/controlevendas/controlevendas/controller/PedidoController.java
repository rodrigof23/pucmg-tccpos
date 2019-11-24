package com.controlevendas.controlevendas.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controlevendas.controlevendas.model.Pedido;
import com.controlevendas.controlevendas.model.Usuario;
import com.controlevendas.controlevendas.service.PedidoService;
import com.controlevendas.controlevendas.util.ResponseUtil;

@Controller
@RequestMapping(path="/pedido")
public class PedidoController {
	
	private static final Logger log = LogManager.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	/**
	 * Rota responsavel por registrar um pedido
	 * 
	 * @param usuario Usuario que realizou a requisicao
	 * @param pedido Pedido para ser cadastrado
	 * @return Pedido cadastrado
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	@PostMapping(path="/cadastrar")
	@ResponseBody
	public Object cadastrarPedido(@RequestAttribute Usuario usuario, @RequestBody Pedido pedido) {
		try {
			return ResponseEntity.ok(this.pedidoService.registrarPedido(usuario, pedido));
		} catch (Exception e) {
			log.error("Erro na requisição /cadastrar.", e);
			return ResponseUtil.returnException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
