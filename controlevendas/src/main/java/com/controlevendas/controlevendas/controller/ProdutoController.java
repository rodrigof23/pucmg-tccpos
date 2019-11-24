package com.controlevendas.controlevendas.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controlevendas.controlevendas.model.Produto;
import com.controlevendas.controlevendas.service.ProdutoService;
import com.controlevendas.controlevendas.util.DeserializadorUtil;
import com.controlevendas.controlevendas.util.ResponseUtil;

@Controller
@RequestMapping(path="/produto")
public class ProdutoController {

	private static final Logger log = LogManager.getLogger(ProdutoController.class);

	private DeserializadorUtil deserializadorUtil = new DeserializadorUtil();
	
	@Autowired
	private ProdutoService produtoService;

	/**
	 * Metodo responsavel por ser chamado para recepcionar a mensagem da SQS
	 *
	 * @param menssagem Mensagem recebida
	 * @throws IOException
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	@JmsListener(destination = "${consumer.sqs.message.queue.name}")
	public void receberProduto(@Payload String menssagem) throws IOException{
		log.info("Menssagem: " + menssagem);
		
		List<Produto> produtos = this.deserializadorUtil.deserializarProdutos(menssagem);
		produtos.forEach(produto -> {
			this.produtoService.registrarProduto(produto);
		});
	}
	
	/**
	 * Rota responsavel por retornar a lista dos produtos
	 * 
	 * @return Lista de produtos
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	@GetMapping(path = "/listar")
	@ResponseBody
	public Object listar() {
		try {
			return ResponseEntity.ok(this.produtoService.listarProdutos());
		} catch (Exception e) {
			log.error("Erro na requisição /listar.", e);
			return ResponseUtil.returnException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
