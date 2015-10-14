package tn.youbay.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Account;

@Remote
public interface IAccountsRemote {
	public  Account getAccountByNameSEC(String name,String secret);
	public void ajouter(Account a );
	public Account getAccountById(int Id);

	public Account getAccountByUsername(String username);
}
