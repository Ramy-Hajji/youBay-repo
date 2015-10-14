package tn.youbay.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;
import tn.youbay.services.interfaces.IProductServiceRemote;

@Stateless
public class ProductService implements IProductServiceRemote{

	@PersistenceContext(name="youbay")
	EntityManager em;
	
	@Override
	public Boolean addProduct(Product p) {
		try {
			em.persist(p);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public Boolean updateProduct(Product p) {
		try {
			em.merge(p);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public Boolean deleteProduct(Product p) {
		try {
			em.remove(em.merge(p));
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public Product findProductById(int ProductId) {
		Product product=null;
		try {
			product = em.find(Product.class, ProductId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		Query query = em.createQuery("select p from Product p");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsBySubCategory(SubCategory SubCategory) {
		Query query = em.createQuery("select p from Product p where p.subCategory=:s");
		query.setParameter("s", SubCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByCategory(Category category) {
		Query query = em.createQuery("select p from Product p where p.category=:s");
		query.setParameter("s", category);
		return query.getResultList();
	}

	

}
