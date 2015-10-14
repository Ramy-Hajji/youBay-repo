package tn.youbay.services;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Accounts;


@Remote
public interface IAccountServiceRemote {
	
	public List<Accounts> findAllAccounts();
	
}
