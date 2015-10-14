package tn.youbay.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.ClientD;
import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;
import tn.youbay.entities.Provider;
import tn.youbay.services.interfaces.IServiceProductRemote;
/**
 * Session Bean implementation class ServiceProduct
 */
@Stateless
public class ServiceProduct implements IServiceProductRemote
{
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ServiceProduct() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addProduct(Product pdt) {
		Boolean b = false;
		try {
			entityManager.persist(pdt);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	
	@Override
	public Boolean addProductOnProvider(Product product,Provider provider)
	{
		Boolean b = false;
		try {
			product.setProvider(provider);
			entityManager.merge(product);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteProductById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Deal.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean updateProduct(Product pdt) {
		Boolean b = false;
		try {
			entityManager.merge(pdt);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Product> readAllProducts() {
		String jpql = "select c from Product c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	@Override
	public List<Product> findAllProductsByProviderId(Integer id) {
		Query query = entityManager
				.createQuery("select p from Product p where p.provider.id=:param1");
		query.setParameter("param1", id);
		return query.getResultList();
	}

	@Override
	public Product findProductById(Integer id) {
		return entityManager.find(Product.class, id);
	}
}
