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
import tn.youbay.services.interfaces.IServiceDealRemote;
/**
 * Session Bean implementation class ServiceDeal
 */
@Stateless
public class ServiceDeal implements IServiceDealRemote
{
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ServiceDeal() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addDeal(Deal d) {
		Boolean b = false;
		try {
			entityManager.persist(d);
			b = true;
			System.out.println("ajout efféctué avec succés");
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteDealById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Deal.class, id));
			b = true;
			System.out.println("le deal ayant l'identifiant "+id+" a été supprimé avec succés");
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean updateDeal(Deal d) {
		Boolean b = false;
		try {
			entityManager.merge(d);
			b = true;
			System.out.println("votre deal a été mis à jour");
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Deal> readAllDeals() {
		String jpql = "select d from Deal d";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	@Override
	public List<Deal> readAllSuccessfulDeals() {
		String jpql = "select d from Deal d WHERE noteClient>5";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Deal findDealById(Integer id) {
		return entityManager.find(Deal.class, id);
	}

	@Override
	public void enableDeal(int id) 
	{
		Query q = entityManager.createQuery("UPDATE Deal d SET d.type = 0 WHERE idDeal=:id" );
		q.setParameter("id", id);
		q.executeUpdate();
		
	}
	
	@Override
	public void disableDeal(int id) 
	{
		Query q = entityManager.createQuery("UPDATE Deal d SET d.type = 1 WHERE idDeal=:id" );
		q.setParameter("id", id);
		q.executeUpdate();
		
	}

	@Override
	public Boolean creeOffreSurProduit(Product product, Deal deal) {
		Boolean b = false;
		try {
			deal.setProduct(product);
			entityManager.merge(deal);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean subscribeClientInOffre(ClientD client, Deal deal) {
		Boolean b = false;
		try {
			List<Deal> deals = findAllOffresByClientId(client.getId());
			deals.add(deal);
			client.setDeals(deals);

			entityManager.merge(client);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Deal> findAllOffresByClientId(Integer id) {
		ClientD clientFound = entityManager.find(ClientD.class, id);
		Query query = entityManager
				.createQuery("select d from Deal d where :param member of d.clients");
		query.setParameter("param", clientFound);
		return query.getResultList();
	}
}
