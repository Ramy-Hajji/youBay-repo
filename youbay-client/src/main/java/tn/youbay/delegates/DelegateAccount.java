package tn.youbay.delegates;

import java.util.List;
import java.util.Random;

import tn.youbay.entities.Account;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.interfaces.IEmailSenderRemote;
import tn.youbay.services.interfaces.IServiceAccount;



public class DelegateAccount {

	
	Random r = new Random(); 
	int valeur = 1 + r.nextInt(5000); 
	String code = ""+valeur+"";
	
	static String jndi ="/PidevEjb/ServiceAccount!edu.esprit.pidev.services.IServiceAccount";
	static String jndi2 ="/PidevEjb/EmailSender!tn.youbay.services.IEmailSenderRemote";
	
	
	
	public static IServiceAccount getinstance()
	{
		return  (IServiceAccount) ServiceLocator.getinstance().getProxy(jndi);

		
		
}
	
	public static IEmailSenderRemote getinstance2()
	{
		return  (IEmailSenderRemote) ServiceLocator.getinstance().getProxy(jndi2);
	
}
	
	
	public  List<Account> DisplayAccount()
	{
		return getinstance().Display();
	}
	
	
	
	
	public void ajouter(Account a)
	{
		getinstance().Ajouter(a);
	}
	
	public void Bann(int id){
		getinstance().Ban(id);
	}
	
	public void UnBann(int id){
		getinstance().Unban(id);
	}
	
	public List<Account> SearchID(int id){
		return getinstance().findbyID(id);
	}
	
	public List<Account> SearchState(String ch){
		 return getinstance().findbyState(ch);
	}
	
	
	public void mail(String[] to ){
		
		
		getinstance2().SendMail("oussama.rekik@esprit.tn", "tigran1993", "Secret Code" , code, to);
	}
	
	public void edit(Account a){
		getinstance().Update(a);
	}
	
	
	
}
