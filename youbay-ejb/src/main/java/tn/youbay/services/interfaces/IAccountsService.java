package tn.youbay.services.interfaces;

import javax.ejb.Remote;

import tn.youbay.entities.Account;

@Remote
public interface IAccountsService{
	public Account getUnAdmin(String username , String secret);
	public Account getClientbyID(int id);
	public void ajoutAccount(Account a);
	public void updateAccount(Account a);
	public void supprimerAccount(Account a);

}
