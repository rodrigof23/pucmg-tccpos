package com.controlevendas.controlevendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_produto", unique = true, nullable = false)
    private Long idProduto;
	
	@Column(name = "nr_codigo", unique = true, nullable = false)
	private Long nrCodigo;
	
	@Column(name = "nm_nome", nullable = false)
	private String nmNome;
	
	@Column(name = "ds_descricao", nullable = false)
	private String dsDescricao;
	
	@Column(name = "nr_valor", nullable = false)
	private Double nrValor;
	
	@Column(name = "url_Imagem", nullable = false)
	private String urlImagem;
	
	@Column(name = "nm_fornecedor", nullable = false)
	private String nmFornecedor;

	public Produto() {
		// Constructor
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getNrCodigo() {
		return nrCodigo;
	}

	public void setNrCodigo(Long nrCodigo) {
		this.nrCodigo = nrCodigo;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Double getNrValor() {
		return nrValor;
	}

	public void setNrValor(Double nrValor) {
		this.nrValor = nrValor;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getNmFornecedor() {
		return nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}
	
}
