package br.com.agenda.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.agenda.dao.DaoGeneric;
import br.com.agenda.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>(); 
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();	 
	
	public String salvar() {
		daoGeneric.salvar(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		return "";
	}
	
	public String salvarEditar() {		
		pessoa = daoGeneric.editarSalvar(pessoa);
		carregarPessoas();
		return "";
	}

	public String delete() {
		daoGeneric.delete(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		return "";
	}
	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoGeneric.lista(Pessoa.class);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	

}
