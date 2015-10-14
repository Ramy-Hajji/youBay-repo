package tn.youbay.delegates;

import tn.youbay.entities.Accounts;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.interfaces.IAccountsService;


public class GestionAccountsDelegate {
	static String jndi = "/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService";

	public static IAccountsService getInstance() {
		return (IAccountsService) ServiceLocator.getinstance().getProxy(jndi);

	}

	public void ajouterCompte(Accounts a) {
		getInstance().ajoutAccount(a);
	}
	
	public void supprimerCompte(Accounts a)
	{
		getInstance().supprimerAccount(a);
	}
	public void updateCompte(Accounts a)
	{
		getInstance().updateAccount(a);
	}
	
	public Accounts getUNADMIIN(String username , String secret)
	{
		return getInstance().getUnAdmin(username, secret);
	}
	public Accounts getCliientbyID(int id)
	{
		return getInstance().getClientbyID(id);
	}


}
