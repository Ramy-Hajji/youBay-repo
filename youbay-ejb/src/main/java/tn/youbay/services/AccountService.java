package tn.youbay.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Accounts;
@Stateless
public class AccountService implements IAccountServiceRemote{
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> findAllAccounts() {
		Query query = em.createQuery("select a from Accounts a");
		return query.getResultList();
	}



	
	

}
