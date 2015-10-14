package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tn.youbay.delegates.GestionAccountsDelegate;
import tn.youbay.delegates.GestionClaimsDelegate;
import tn.youbay.entities.Account;
import tn.youbay.entities.Claims;

public class testAccounts {

	@Test
	public void test() {
//		GestionAccountsDelegate gdl = new GestionAccountsDelegate();
//		Accounts a = new Accounts();
//		a.setId(1);
//		//gdl.supprimerCompte(a);
//		GestionClaimsDelegate gc= new GestionClaimsDelegate();
//		//gc.supprimerClaim(new Claims(1, "waa", 2));
//		Accounts res =gdl.getUNADMIIN("ouss", "123");
//		System.out.println(res);
		
		GestionAccountsDelegate gdl = new GestionAccountsDelegate();
		GestionClaimsDelegate gdc = new GestionClaimsDelegate();
		Account a = new Account();
		a.setUsername("oussff1");
		a.setSecret_number("123");
		//gdl.ajouterCompte(a);
		Claims cc = new Claims();
		//gdl.ajouterCompte(a);
		cc.setAccount(a);
		gdc.ajouterClaim(cc);
	}

}
