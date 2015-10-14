package tn.youbay.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Accounts;
import tn.youbay.entities.Claims;

@Stateless
@LocalBean
public class ClaimsDao {
	@PersistenceContext(unitName="ejb-sample")
	EntityManager em;
	public List<Claims> getAllClaims()
	{
		Query q = em.createQuery("select c from Claims c");
		return q.getResultList();
		
	}
	public void  DeleteClaim(Claims c)
	{
		try{
			em.remove(em.merge(c));

		}catch(Exception e)
		{
			System.out.println("laaaa");
		}
	}
	public void AddClaim(Claims c)
	{
		em.persist(c);
	}
	public List<Claims> Recherche (String usern)
	{
		Query q = em.createQuery("SELECT c.Id,c.username FROM Accounts c JOIN c.listOfclaims a WHERE c.username=:user");
		q.setParameter("user", usern);
		System.out.println(q.getResultList()+"aaaaa");
		
		List<Claims> lc =(List<Claims>)q.getResultList();
		for(Claims c :lc)
		{
			System.out.println(c);
		}
		return lc;
//		Query q = em.createQuery("SELECT a FROM Accounts a WHERE a.username LIKE:id" );
//		q.setParameter("id","%" +usern+  "%");
//		Accounts compte = (Accounts) q.getSingleResult();
//	
//
//		Query q1 = em.createQuery("SELECT c FROM Claims c WHERE c.account=:id" );
//		q1.setParameter("id" , compte.getId() );
//
//		return q1.getResultList();
	}

}
