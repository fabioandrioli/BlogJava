package br.com.fabio.blog.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column (name = "categoryId")
	//private int category_id;
	private String image;
	private String title;
	private String description;
	//relacionamento de tabelas
	
	@ManyToOne //Muitos produtos estão relacionado com uma categoria.
	//Ele ja identifica que a categoria é um entidade por na classe categoria estar a anotacao @entity
	@JoinColumn(name = "categoryId")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "product")
	List<ItemPedido> itemPedido;
	
	private LocalDateTime created_at = LocalDateTime.now();
	private LocalDateTime updated_at = LocalDateTime.now();
	
	
	public Product() {
		
	}
	
	public Product(String image, String title, String description, Categoria categoria) {
		this.image = image;
		this.title = title;
		this.description = description;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
