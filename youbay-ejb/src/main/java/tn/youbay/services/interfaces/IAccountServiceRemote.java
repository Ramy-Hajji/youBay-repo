package tn.youbay.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Account;


@Remote
public interface IAccountServiceRemote {
	
	public List<Account> findAllAccounts();
	
}
