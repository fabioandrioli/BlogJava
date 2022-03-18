package br.com.fabio.blog.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	
	//@ManyToMany
	 //@JoinTable() //para personalizar o nome da tabela
	//List<Porduct> produto;
	
	
	//Quando a tabela pivo de muitos para muitos, tem mais campos. Criamos uma classe especifica pra inserir esses campos
	@ManyToMany
	List<ItemPedido> itemPedido;
	
	public Cliente(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
