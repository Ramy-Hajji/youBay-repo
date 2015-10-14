package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.youbay.entities.Claims;
import tn.youbay.services.interfaces.IClaimService;

public class testClaims {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			IClaimService remote;
			remote = (IClaimService) context
					.lookup("/youbay-ejb/ClaimService!tn.youbay.services.IClaimService");
			remote.AddClaiim(new Claims("Reee", 8));
			remote.DeleteClaiim(new Claims(5, "Reee", 8));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
