package tn.youbay.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Account;

@Remote
public interface IServiceAccount {

	public void Ajouter(Account a);

	public void Supprimer(Account a);

	public void Update(Account a);

	public List<Account> Display();

	public void Ban(int id);

	public void Unban(int id);

	public List<Account> findbyID(int id);

	public List<Account> findbyState(String state);

}
