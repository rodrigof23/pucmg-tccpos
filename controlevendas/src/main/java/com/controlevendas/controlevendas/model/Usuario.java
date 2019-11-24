package com.controlevendas.controlevendas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    private Long idUsuario;
	
	@Column(name = "nm_email", unique = true, nullable = false)
    private String nmEmail;
	
	@Column(name = "nm_senha", nullable = false)
    private String nmSenha;
	
	@Column(name = "nm_nome", nullable = false)
    private String nmNome;
	
	@Column(name = "nr_cpf", unique = true, nullable = false)
    private Long nrCpf;
	
	@Column(name = "fl_sexo", nullable = false)
    private char flSexo;
	
	@Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;
	
	@Column(name = "dt_cadastro", nullable = false)
    private Date dtCadastro = new Date();
	
	@Column(name = "nr_perfil_acesso", nullable = false)
	private Long nrPerfilAcesso;
	
	public Usuario() {
		// Constructor
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getNmSenha() {
		return nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public Long getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(Long nrCpf) {
		this.nrCpf = nrCpf;
	}

	public char getFlSexo() {
		return flSexo;
	}

	public void setFlSexo(char flSexo) {
		this.flSexo = flSexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Long getNrPerfilAcesso() {
		return nrPerfilAcesso;
	}

	public void setNrPerfilAcesso(Long nrPerfilAcesso) {
		this.nrPerfilAcesso = nrPerfilAcesso;
	}
	
}
