package tn.youbay.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Claims implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String content;
//	int idClient;
	@ManyToOne(targetEntity=Account.class,fetch=FetchType.EAGER)
	@JoinColumn(insertable=false,updatable=false,name="account")

	Account account;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public int getIdClient() {
//		return idClient;
//	}
//	public void setIdClient(int idClient) {
//		this.idClient = idClient;
//	}
	public Claims() {
		super();
	}
	public Claims(String content) {
		super();
		this.content = content;
//		this.idClient = idClient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Claims(int Id,String content) {
		super();
		this.id=Id;
		this.content = content;
//		this.idClient = idClient;
	
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Claims [id=" + id + ", content=" + content + ", account="
				+ account + "]";
	}
	

}
