package tn.youbay.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.youbay.dao.ManageProductDomain;
import tn.youbay.entities.Product;

@Stateless
public class ServiceProduit implements IServiceProduit{
	@EJB
	ManageProductDomain e ;
	
	
	
public void activate(int id){
		
		
		e.ActivateProduct( id);
	}

public void delete(int id) {
		
		e.DeleteProduct(id);
	}

public List<Product> Search(String Name) {
	
	return e.SearchProduct(Name);
}

public void Edit(Product p){
		
		
		e.EditProduct(p);
	}
public List<Product> FindAll() {
	
	return e.SelectAll();

}


}
