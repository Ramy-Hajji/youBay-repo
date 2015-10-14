package tn.youbay.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Accounts;

@Remote
public interface IAccountsRemote {
	public  Accounts getAccountByNameSEC(String name,String secret);
	public void ajouter(Accounts a );
	public Accounts getAccountById(int Id);

	public Accounts getAccountByUsername(String username);
}
