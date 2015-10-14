package tn.youbay.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Accounts;

@Stateless
@LocalBean
public class AccountsDao {
	@PersistenceContext(unitName="ejb-sample")
	EntityManager em;
	public void supprimerAccounts(Accounts a)
	{
		try{
			em.remove(em.merge(a));

		}catch(Exception e)
		{
			System.out.println("laaaa");
		}	
		}
	public void ajouterAccounts(Accounts a )
	{
		em.persist(a);
	}
	
	public void updateAccounts(Accounts a)
	{
		em.merge(a);
	}
	public Accounts getAccountByNameSEC(String name,String secret)
		{

Query q = em.createQuery("select e from Accounts e WHERE e.username=:name AND e.secret_number=:secret");
q.setParameter("name", name);
q.setParameter("secret", secret);


return (Accounts) q.getSingleResult();
	
	}
	public Accounts getAccountById(int Id)
	{

Query q = em.createQuery("select e from Accounts e WHERE e.Id=:Id");
q.setParameter("Id", Id);


return (Accounts) q.getSingleResult();

}
	
	public Accounts getAccountByUsername(String username)
	{

Query q = em.createQuery("select e from Accounts e WHERE e.username=:Id");
q.setParameter("Id", username);


return (Accounts) q.getSingleResult();

}

}
