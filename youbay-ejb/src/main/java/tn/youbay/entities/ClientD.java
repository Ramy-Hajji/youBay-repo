package tn.youbay.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
public class ClientD implements Serializable {

	private Integer id;
	private String nom;
	private static final long serialVersionUID = 1L;

	private List<Deal> deals;

	public ClientD() {
		super();
	}

	@Id
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

	@ManyToMany(cascade = CascadeType.MERGE)
	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
