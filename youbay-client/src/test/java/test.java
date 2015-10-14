import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.youbay.dao.IAccountsDaoLocal;
import tn.youbay.services.interfaces.IEmailSenderRemote;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Context context =  new InitialContext();
			IAccountsDaoLocal remote;
			remote=(IAccountsDaoLocal) context.lookup("/youbay-ejb/AccountsDao!tn.youbay.dao.IAccountsDaoLocal");
			System.out.println(remote.getAccountByNameSEC("ouss", "ouss"));
			} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
