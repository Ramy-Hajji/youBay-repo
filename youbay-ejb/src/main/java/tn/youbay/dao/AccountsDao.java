package tn.youbay.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Account;

@Stateless
@LocalBean
public class AccountsDao {
	@PersistenceContext(unitName="ejb-sample")
	EntityManager em;
	public void supprimerAccounts(Account a)
	{
		try{
			em.remove(em.merge(a));

		}catch(Exception e)
		{
			System.out.println("laaaa");
		}	
		}
	public void ajouterAccounts(Account a )
	{
		em.persist(a);
	}
	
	public void updateAccounts(Account a)
	{
		em.merge(a);
	}
	public Account getAccountByNameSEC(String name,String secret)
		{

Query q = em.createQuery("select e from Accounts e WHERE e.username=:name AND e.secret_number=:secret");
q.setParameter("name", name);
q.setParameter("secret", secret);


return (Account) q.getSingleResult();
	
	}
	public Account getAccountById(int Id)
	{

Query q = em.createQuery("select e from Accounts e WHERE e.Id=:Id");
q.setParameter("Id", Id);


return (Account) q.getSingleResult();

}
	
	public Account getAccountByUsername(String username)
	{

Query q = em.createQuery("select e from Accounts e WHERE e.username=:Id");
q.setParameter("Id", username);


return (Account) q.getSingleResult();

}

}
