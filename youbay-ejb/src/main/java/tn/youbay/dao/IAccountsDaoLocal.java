package tn.youbay.dao;



import java.util.List;

import javax.ejb.Local;

import tn.youbay.entities.Accounts;
@Local
public interface IAccountsDaoLocal {
	public  Accounts  getAccountByNameSEC(String name,String secret);
	public void ajouter(Accounts a );
}
