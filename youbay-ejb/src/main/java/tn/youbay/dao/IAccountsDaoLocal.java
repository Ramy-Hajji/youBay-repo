package tn.youbay.dao;



import java.util.List;

import javax.ejb.Local;

import tn.youbay.entities.Account;
@Local
public interface IAccountsDaoLocal {
	public  Account  getAccountByNameSEC(String name,String secret);
	public void ajouter(Account a );
}
