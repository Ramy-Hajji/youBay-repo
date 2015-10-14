package tn.youbay.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Account;
import tn.youbay.services.interfaces.IServiceAccount;

@Stateless
public class ServiceAccount implements IServiceAccount {

	@PersistenceContext(name = "Managementaccount")
	EntityManager em;

	@Override
	public void Ajouter(Account a) {
		em.persist(a);

	}

	@Override
	public void Supprimer(Account a) {

		em.remove(a);
	}

	@Override
	public void Update(Account a) {

		em.merge(a);
	}

	@Override
	public List<Account> Display() {

		Query q = em.createQuery("select e from Account e ");

		return q.getResultList();
	}

	@Override
	public void Ban(int id) {
		Query q = em
				.createQuery("UPDATE Account a SET a.state = 'Disactivated' WHERE  a.state='Activated' and idAccount=:id ");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	public void Unban(int id) {

		Query q = em
				.createQuery("UPDATE Account a SET a.state = 'Activated' WHERE  a.state='Disactivated' and idAccount=:id ");
		q.setParameter("id", id);
		q.executeUpdate();

	}

	@Override
	public List<Account> findbyID(int id) {

		Query q = em
				.createQuery("select e from Account e where idAccount=:id ");
		q.setParameter("id", id);
		return q.getResultList();
	}

	@Override
	public List<Account> findbyState(String state) {

		Query q = em
				.createQuery("SELECT e FROM Account e WHERE e.state=:state ");
		q.setParameter("state", state);
		return q.getResultList();
	}

	/*



	*/

}
