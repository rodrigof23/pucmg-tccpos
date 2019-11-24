package com.controlevendas.controlevendas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pedido", unique = true, nullable = false)
    private Long idPedido;
	
	@Column(name = "nr_quantidade", nullable = false)
	private Long nrQuantidade;
	
	@Column(name = "nr_valor_total", nullable = false)
	private Double nrValorTotal;
	
	@Column(name = "fl_status", nullable = false)
	private int flStatus = 0;
	
	@Column(name = "dt_pedido", nullable = false)
	private Date dtPedido = new Date();
	
	@ManyToOne
    @JoinColumn(name ="fk_usuario", nullable = false)
	private Usuario fkUsuario;
	
	@ManyToOne
    @JoinColumn(name ="fk_produto", nullable = false)
	private Produto fkProduto;
	
	@ManyToOne
    @JoinColumn(name ="fk_endereco", nullable = false)
	private Endereco fkEndereco;
	
	@ManyToOne
    @JoinColumn(name ="fk_cartao", nullable = false)
	private Cartao fkCartao;
	
	public Pedido() {
		// Constructor
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getNrQuantidade() {
		return nrQuantidade;
	}

	public void setNrQuantidade(Long nrQuantidade) {
		this.nrQuantidade = nrQuantidade;
	}

	public Double getNrValorTotal() {
		return nrValorTotal;
	}

	public void setNrValorTotal(Double nrValorTotal) {
		this.nrValorTotal = nrValorTotal;
	}

	public int getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(int flStatus) {
		this.flStatus = flStatus;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public Usuario getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public Produto getFkProduto() {
		return fkProduto;
	}

	public void setFkProduto(Produto fkProduto) {
		this.fkProduto = fkProduto;
	}

	public Endereco getFkEndereco() {
		return fkEndereco;
	}

	public void setFkEndereco(Endereco fkEndereco) {
		this.fkEndereco = fkEndereco;
	}

	public Cartao getFkCartao() {
		return fkCartao;
	}

	public void setFkCartao(Cartao fkCartao) {
		this.fkCartao = fkCartao;
	}

}
