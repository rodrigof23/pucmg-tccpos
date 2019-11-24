package com.controlevendas.controlevendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartao")
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_cartao", unique = true, nullable = false)
    private Long idCartao;
	
	@Column(name = "nm_titular_nome", nullable = false)
	private String nmTitularNome;
	
	@Column(name = "nr_titular_cpf", nullable = false)
	private Long nrTitularCpf;
	
	@Column(name = "nr_numero_cartao", nullable = false)
	private Long nrNumeroCartao;
	
	@Column(name = "nr_codigo_seguranca", nullable = false)
	private Long nrCodigoSeguranca;
	
	@Column(name = "nr_validade_mes", nullable = false)
	private Long nrValidadeMes;
	
	@Column(name = "nr_validade_ano", nullable = false)
	private Long nrValidadeAno;
	
	public Cartao() {
		// Constructor
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public String getNmTitularNome() {
		return nmTitularNome;
	}

	public void setNmTitularNome(String nmTitularNome) {
		this.nmTitularNome = nmTitularNome;
	}

	public Long getNrTitularCpf() {
		return nrTitularCpf;
	}

	public void setNrTitularCpf(Long nrTitularCpf) {
		this.nrTitularCpf = nrTitularCpf;
	}

	public Long getNrNumeroCartao() {
		return nrNumeroCartao;
	}

	public void setNrNumeroCartao(Long nrNumeroCartao) {
		this.nrNumeroCartao = nrNumeroCartao;
	}

	public Long getNrCodigoSeguranca() {
		return nrCodigoSeguranca;
	}

	public void setNrCodigoSeguranca(Long nrCodigoSeguranca) {
		this.nrCodigoSeguranca = nrCodigoSeguranca;
	}

	public Long getNrValidadeMes() {
		return nrValidadeMes;
	}

	public void setNrValidadeMes(Long nrValidadeMes) {
		this.nrValidadeMes = nrValidadeMes;
	}

	public Long getNrValidadeAno() {
		return nrValidadeAno;
	}

	public void setNrValidadeAno(Long nrValidadeAno) {
		this.nrValidadeAno = nrValidadeAno;
	}
	
}
