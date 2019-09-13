package com.gerenciadorapp.gerenciadorapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class ArquivoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = UsuarioModel.class)
	@JoinTable(name = "Arquivo_Usuario", joinColumns = @JoinColumn(name = "usuario"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<UsuarioModel> usuarios;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String dados;

	private Long usuario;

	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ArquivoModel [id=" + id + ", nome=" + nome + ", dados=" + dados + ", usuario=" + usuario + "]";
	}
}
