package test;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.youbay.entities.Account;
import tn.youbay.entities.Role;
import tn.youbay.services.interfaces.IServiceAccount;



public class testAccount {

	public static void main(String[] args) {
		
		Context context;
		
		try {
			context = new InitialContext();
		    IServiceAccount remote;
			remote = (IServiceAccount)context.lookup("/PidevEjb/ServiceAccount!edu.esprit.pidev.services.IServiceAccount");
			
			Account a = new Account();
			Role r = new Role();
		    List<Account> list = new ArrayList<Account>();
		     
			r.setIdRole(5);
			r.setRole("Admin");
			a.se
			a.setAddress("tunis,Ariana");
			a.setCode_bank("08fdfd84");
			a.setFirstName("cfff");
			a.setLastName("sqfhbr");
			a.setSecret_number("0250");
			a.setState("Disactivated");
			a.setEmail("foulen.ben@gmail.com");
			a.setUsername("Cyrine");
          //  a.setRole(r);
          
            
      /*      list.add(a);
            r.setList(list);
            
        */    
          
            
			remote.Ajouter(a);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
