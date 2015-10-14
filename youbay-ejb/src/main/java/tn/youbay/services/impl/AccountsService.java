package tn.youbay.services.impl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import tn.youbay.dao.AccountsDao;
import tn.youbay.entities.Account;
import tn.youbay.services.interfaces.IAccountsService;

@Stateless
public class AccountsService implements IAccountsService,Serializable{
	@EJB
	AccountsDao d;
	
	public Account getUnAdmin(String username , String secret)
	{
		return d.getAccountByNameSEC(username, secret);
	}
	public Account getClientbyID(int id)
	{
		return d.getAccountById(id);
		}
	
	public void ajoutAccount(Account a)
	{
		d.ajouterAccounts(a);
	}
	public void updateAccount(Account a)
	{
		d.updateAccounts(a);
	}
	public void supprimerAccount(Account a)
	{
		d.supprimerAccounts(a);
	}

}
