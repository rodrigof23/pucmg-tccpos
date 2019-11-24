package com.controlevendas.controlevendas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.controlevendas.controlevendas.dao.CartaoDao;
import com.controlevendas.controlevendas.dao.EnderecoDao;
import com.controlevendas.controlevendas.dao.PedidoDao;
import com.controlevendas.controlevendas.model.Pedido;
import com.controlevendas.controlevendas.model.Usuario;
import com.controlevendas.controlevendas.util.AWSUtil;

@Service
public class PedidoService {

	private static final Logger log = LogManager.getLogger(PedidoService.class);
	
	@Value("${aws.sns.notification.topic}")
	private String topico;
	
	@Autowired
	private PedidoDao pedidoDao;
	@Autowired
	private EnderecoDao enderecoDao;
	@Autowired
	private CartaoDao cartaoDao;

	/**
	 * Metodo responsavel por registrar um pedido recebido
	 *
	 * @param usuario Usuario que realizou a requisicao
	 * @param pedido Objeto pedido que sera registrado
	 * @throws Exception 
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	public Pedido registrarPedido(Usuario usuario, Pedido pedido) throws Exception {
		pedido.setFkUsuario(usuario);
		pedido.setFkEndereco(this.enderecoDao.save(pedido.getFkEndereco()));
		pedido.setFkCartao(this.cartaoDao.save(pedido.getFkCartao()));
		pedido = this.pedidoDao.save(pedido);
		log.info("Novo pedido registrado! ID: " + pedido.getIdPedido());
		
		AWSUtil.enviaNotificacaoAWS(this.topico, pedido);
		return pedido;
	}

}
