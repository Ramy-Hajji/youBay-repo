package tn.youbay.services.interfaces;

import javax.ejb.Remote;

import tn.youbay.entities.Accounts;

@Remote
public interface IAccountsService{
	public Accounts getUnAdmin(String username , String secret);
	public Accounts getClientbyID(int id);
	public void ajoutAccount(Accounts a);
	public void updateAccount(Accounts a);
	public void supprimerAccount(Accounts a);

}
