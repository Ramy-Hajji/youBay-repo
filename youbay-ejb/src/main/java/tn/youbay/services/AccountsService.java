package tn.youbay.services;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import tn.youbay.dao.AccountsDao;
import tn.youbay.entities.Accounts;

@Stateless
public class AccountsService implements IAccountsService,Serializable{
	@EJB
	AccountsDao d;
	
	public Accounts getUnAdmin(String username , String secret)
	{
		return d.getAccountByNameSEC(username, secret);
	}
	public Accounts getClientbyID(int id)
	{
		return d.getAccountById(id);
		}
	
	public void ajoutAccount(Accounts a)
	{
		d.ajouterAccounts(a);
	}
	public void updateAccount(Accounts a)
	{
		d.updateAccounts(a);
	}
	public void supprimerAccount(Accounts a)
	{
		d.supprimerAccounts(a);
	}

}
