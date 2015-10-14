package tn.youbay.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity

public class Accounts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

	private int Id;
	@Column(unique=true)

	private String username;
	private Date date,dateofBirth;
	private String code_bank,firstName,lastName,Address,secret_number,State,email;
	@OneToMany(targetEntity=Claims.class,mappedBy="account",fetch=FetchType.EAGER)
	private List<Claims> listOfclaims;
	@OneToMany(mappedBy="account")
	private List<Product> products;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getCode_bank() {
		return code_bank;
	}
	public void setCode_bank(String code_bank) {
		this.code_bank = code_bank;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getSecret_number() {
		return secret_number;
	}
	public void setSecret_number(String secret_number) {
		this.secret_number = secret_number;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Accounts [Id=" + Id + ", date=" + date + ", dateofBirth="
				+ dateofBirth + ", code_bank=" + code_bank + ", firstName="
				+ firstName + ", lastName=" + lastName + ", Address=" + Address
				+ ", secret_number=" + secret_number + ", State=" + State
				+ ", email=" + email + "]";
	}
	public Accounts(int id, String firstName) {
		super();
		Id = id;
		this.firstName = firstName;
	}
	public Accounts() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Accounts(int id, String username, Date date, Date dateofBirth,
			String code_bank, String firstName, String lastName,
			String address, String secret_number, String state, String email) {
		super();
		Id = id;
		this.username = username;
		this.date = date;
		this.dateofBirth = dateofBirth;
		this.code_bank = code_bank;
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		this.secret_number = secret_number;
		State = state;
		this.email = email;
	}
	public List<Claims> getListOfclaims() {
		return listOfclaims;
	}
	public void setListOfclaims(List<Claims> listOfclaims) {
		this.listOfclaims = listOfclaims;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
