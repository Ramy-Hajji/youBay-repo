package tn.youbay.services;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Product;


@ Remote
public interface IServiceProduit {
	public void activate(int id);
	public void delete(int p);
	public void Edit(Product p);
	public List<Product> FindAll();
	public List<Product> Search(String Name) ;

		
}
