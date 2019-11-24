package com.controlevendas.controlevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlevendas.controlevendas.dao.ProdutoDao;
import com.controlevendas.controlevendas.model.Produto;

@Service
public class ProdutoService {

	private static final Logger log = LogManager.getLogger(ProdutoService.class);

	@Autowired
	private ProdutoDao produtoDao;

	/**
	 * Metodo responsavel por registrar um produto recebido
	 *
	 * @param produto Objeto produto
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	public void registrarProduto(Produto produto) {
		try {
			Produto produtoExistente = this.produtoDao.findByNrCodigo(produto.getNrCodigo());
			if (produtoExistente == null) {
				produto = this.produtoDao.save(produto);
				log.info("Novo produto registrado! Codigo: " + produto.getNrCodigo());
			} else {
				produtoExistente.setNmNome(produto.getNmNome());
				produtoExistente.setDsDescricao(produto.getDsDescricao());
				produtoExistente.setNrValor(produto.getNrValor());
				produtoExistente.setUrlImagem(produto.getUrlImagem());
				produtoExistente.setNmFornecedor(produto.getNmFornecedor());
				this.produtoDao.save(produtoExistente);
				log.info("Produto atualizado! Codigo: " + produto.getNrCodigo());
			}
		} catch (Exception e) {
			log.error("Erro ao cadastrar produto.", e);
		}
	}
	
	/**
	 * Metodo responsavel por listar os produtos registrados
	 * 
	 * @return Lista de produtos
	 * 
	 * @author Rodrigo de Freitas Santos
	 */
	public List<Produto> listarProdutos() {
		List<Produto> produtos = new ArrayList<>();
		this.produtoDao.findAll().forEach(produtos::add);
		return produtos;
	}

}
