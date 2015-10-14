package tn.youbay.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
public class Provider implements Serializable {

	private Integer id;
	private String nom;
	private List<Product> products;
	private static final long serialVersionUID = 1L;

	public Provider() {
		super();
	}

	public Provider(Integer id,String nom) {
		super();
		this.id=id;
		this.nom = nom;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToMany(mappedBy = "provider")
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
