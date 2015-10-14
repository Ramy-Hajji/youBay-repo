package tn.youbay.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Product;


@LocalBean
@Stateless
public class ManageProductDomain {
	@PersistenceContext(unitName = "ejb-sample")
	EntityManager em;

	public void ActivateProduct(int id) {
		
		Query q = em.createQuery("UPDATE Product p SET p.state = 'enabled' WHERE p.state= 'disabled' and Id_Product=:id" );
		q.setParameter("id", id);
		q.executeUpdate();

	}

	public void DeleteProduct(int id_P) {

		Query q = em.createQuery("delete from Product p WHERE p.Id_Product=:id" );
		q.setParameter("id", id_P);
		q.executeUpdate();

	}
	public List<Product> SearchProduct(String Name) {

		Query q = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE:id" );
		q.setParameter("id","%" + Name + "%");

		return q.getResultList();

	}

	public void EditProduct(Product p) {

		em.merge(p);
	}
	
	public List<Product> SelectAll() {
		List<Product> l = new ArrayList<Product>();
		
		Query q = em.createQuery("select p from Product p");
		l=q.getResultList();
		return l ;
	}
	
	
		 
		  

}
