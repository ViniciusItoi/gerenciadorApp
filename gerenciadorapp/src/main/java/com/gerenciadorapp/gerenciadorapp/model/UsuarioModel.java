package com.gerenciadorapp.gerenciadorapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UsuarioModel implements /* UserDetails, */ Serializable {

	private static final long serialVersionUID = 2L;

	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "usuarios", targetEntity = ArquivoModel.class)
	private List<ArquivoModel> arquivos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String usuario;

	private String senha;

	private Boolean isAdm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAdm() {
		return isAdm;
	}

	public void setIsAdm(Boolean isAdm) {
		this.isAdm = isAdm;
	}

	public Collection<ArquivoModel> getArquivos() {
		return arquivos;
	}
	
	public void setArquivos(List<ArquivoModel> arquivos) {
		this.arquivos = arquivos;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", usuario=" + usuario + ", isAdm=" + isAdm + "]";
	}

}