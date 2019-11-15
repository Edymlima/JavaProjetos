package br.com.agenda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
  	private String fone;
  	private int tipo;

  	private long id_pessoa;
  	
  	public Telefone() {
		
	}
  	
	public long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", fone=" + fone + ", tipo=" + tipo + ", id_pessoa=" + id_pessoa + "]";
	}

  	
    
}
