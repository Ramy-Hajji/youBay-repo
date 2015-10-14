package tn.youbay.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Account implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) //auto increment
	private int idAccount ;
	private String firstName ;
	private String lastName ;
	private Date dateCreation ;
	private String codeBank ;
	private String Adresse ;
	private Date dateOfBirth ;
	private String secretNumber ;
	private String mail ;
	private String state ;
	
	@ManyToOne(optional=true)
	private Role role ;
	
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Account(){
		
	}
	
	
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getCodeBank() {
		return codeBank;
	}
	public void setCodeBank(String codeBank) {
		this.codeBank = codeBank;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSecretNumber() {
		return secretNumber;
	}
	public void setSecretNumber(String secretNumber) {
		this.secretNumber = secretNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
	

}
