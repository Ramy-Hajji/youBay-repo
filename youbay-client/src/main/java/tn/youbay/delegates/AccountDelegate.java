package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.Account;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.interfaces.IAccountServiceRemote;


public class AccountDelegate {
	
private static final String jndi = "/youbay-ejb/AccountService!tn.youbay.services.IAccountServiceRemote";
	
	private static IAccountServiceRemote getProxy(){
		
		return (IAccountServiceRemote) ServiceLocator.getinstance().getProxy(jndi);
	}
	
	public static List<Account> dofindAllAccounts() {
		return getProxy().findAllAccounts();
	}
}
