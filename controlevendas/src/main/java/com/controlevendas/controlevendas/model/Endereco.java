package com.controlevendas.controlevendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_endereco", unique = true, nullable = false)
    private Long idEndereco;
	
	@Column(name = "nr_cep", nullable = false)
	private Long nrCep;
	
	@Column(name = "nm_rua", nullable = false)
	private String nmRua;
	
	@Column(name = "nr_numero", nullable = false)
	private Long nrNumero;
	
	@Column(name = "nm_bairro", nullable = false)
	private String nmBairro;
	
	@Column(name = "ds_complemento", nullable = true)
	private String dsComplemento;
	
	@Column(name = "ds_referencia", nullable = true)
	private String dsReferencia;
	
	public Endereco() {
		// Constructor
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Long getNrCep() {
		return nrCep;
	}

	public void setNrCep(Long nrCep) {
		this.nrCep = nrCep;
	}

	public String getNmRua() {
		return nmRua;
	}

	public void setNmRua(String nmRua) {
		this.nmRua = nmRua;
	}

	public Long getNrNumero() {
		return nrNumero;
	}

	public void setNrNumero(Long nrNumero) {
		this.nrNumero = nrNumero;
	}

	public String getNmBairro() {
		return nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsReferencia() {
		return dsReferencia;
	}

	public void setDsReferencia(String dsReferencia) {
		this.dsReferencia = dsReferencia;
	}

}
