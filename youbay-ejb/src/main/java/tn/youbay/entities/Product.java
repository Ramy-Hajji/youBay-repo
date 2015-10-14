package tn.youbay.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Product;
	private double price;
	private String brand;
	private int quantity;
	private String state;
	private byte[] picture;
	private String description;
	private String name;
	@Enumerated
	private PaymentWay payment_way; 
	
	@ManyToOne
	@JoinColumn(name="account")
	private Accounts account;
	
	@ManyToOne
	@JoinColumn(name="subCategory")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name="category")
	private Category category;
	
	
	public int getId_product() {
		return Id_Product;
	}
	public void setId_product(int id_product) {
		this.Id_Product = id_product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Lob
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PaymentWay getPayment_way() {
		return payment_way;
	}
	public void setPayment_way(PaymentWay payment_way) {
		this.payment_way = payment_way;
	}
	
	public Product(int id_Product, String nom, PaymentWay payment_way,String brand, double price,
			int quantite, String state,String description) {
		super();
		this.Id_Product = id_Product;
		this.name = nom;
		this.brand = brand;
		this.price = price;
		this.quantity = quantite;
		this.payment_way = payment_way;
		this.state = state;
		this.description=description;
	}
		public Product(int id_Product,String nom,String brand,PaymentWay payment_way,double price,
				 String state,int quantite,String description) {
			super();
			this.Id_Product = id_Product;

			this.Id_Product = id_Product;
			this.name = nom;
			this.brand = brand;
			this.price = price;
			this.quantity = quantite;
			this.payment_way = payment_way;
			this.state = state;
			this.description=description;
		}
		public Product() {
			super();
		}
	
	
	
	
	

}
