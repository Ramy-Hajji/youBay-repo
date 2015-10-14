package test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.youbay.dao.IAccountsDaoLocal;
import tn.youbay.dao.IAccountsRemote;
import tn.youbay.entities.Accounts;
import tn.youbay.services.interfaces.IAccountsService;
import tn.youbay.services.interfaces.IEmailSenderRemote;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Context context =  new InitialContext();
			IAccountsService remote;
			remote=(IAccountsService) context.lookup("/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService");
			System.out.println(remote.getUnAdmin("s", "1"));
			} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
