package tn.youbay.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Deal
 *
 */

@Entity
public class Deal implements Serializable {
	private int idDeal;
	@Enumerated(EnumType.STRING)
	private TypeDeal type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startingDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	private float discount;
	private int noteClient;

	private List<ClientD> clients;
	private Product product;

	public Deal() {
	}

	public Deal(int idDeal, TypeDeal type, Date startingDate, Date deadline,
			float discount, Product product, List<ClientD> clients) {
		super();
		this.idDeal = idDeal;
		this.type = type;
		this.startingDate = startingDate;
		this.deadline = deadline;
		this.discount = discount;
		this.clients = clients;
	}

	public Deal(int idDeal, TypeDeal type, Date startingDate, Date deadline,
			float discount, Product product) {
		super();
		this.idDeal = idDeal;
		this.type = type;
		this.startingDate = startingDate;
		this.deadline = deadline;
		this.discount = discount;
	}
	
	public Deal(int idDeal, Date startingDate, Date deadline, float discount) {
		super();
		this.idDeal = idDeal;
		this.startingDate = startingDate;
		this.deadline = deadline;
		this.discount = discount;
	}

	public Deal(TypeDeal type, Date startingDate, Date deadline,
			float discount, Product product, List<ClientD> clients) {
		super();
		this.type = type;
		this.startingDate = startingDate;
		this.deadline = deadline;
		this.discount = discount;
		this.clients = clients;
	}

	@Id
	public int getIdDeal() {
		return idDeal;
	}

	public void setIdDeal(int idDeal) {
		this.idDeal = idDeal;
	}

	public TypeDeal getType() {
		return type;
	}

	public void setType(TypeDeal type) {
		this.type = type;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@ManyToMany(mappedBy = "deals")
	public List<ClientD> getClients() {
		return clients;
	}

	public void setClients(List<ClientD> clients) {
		this.clients = clients;
	}

	public int getNoteClient() {
		return noteClient;
	}

	public void setNoteClient(int noteClient) {
		this.noteClient = noteClient;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
