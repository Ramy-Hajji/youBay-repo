package tn.youbay.delegates;

import tn.youbay.entities.Account;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.interfaces.IAccountsService;


public class GestionAccountsDelegate {
	static String jndi = "/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService";

	public static IAccountsService getInstance() {
		return (IAccountsService) ServiceLocator.getinstance().getProxy(jndi);

	}

	public void ajouterCompte(Account a) {
		getInstance().ajoutAccount(a);
	}
	
	public void supprimerCompte(Account a)
	{
		getInstance().supprimerAccount(a);
	}
	public void updateCompte(Account a)
	{
		getInstance().updateAccount(a);
	}
	
	public Account getUNADMIIN(String username , String secret)
	{
		return getInstance().getUnAdmin(username, secret);
	}
	public Account getCliientbyID(int id)
	{
		return getInstance().getClientbyID(id);
	}


}
