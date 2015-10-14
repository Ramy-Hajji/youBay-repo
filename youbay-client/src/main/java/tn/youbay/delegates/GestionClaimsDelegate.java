package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.Claims;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.IClaimService;

public class GestionClaimsDelegate {
	static String jndi = "/youbay-ejb/ClaimService!tn.youbay.services.IClaimService";

	public static IClaimService getInstance() {
		return (IClaimService) ServiceLocator.getinstance().getProxy(jndi);

	}
	public void supprimerClaim(Claims c)
	{
		getInstance().DeleteClaiim(c);
	}
	
	public void ajouterClaim(Claims c)
	{
		getInstance().AddClaiim(c);
	}
	public List<Claims> ListOfClaims()
	{
		return getInstance().ListOfClaims();
	}
	public List<Claims> RechercheClaim(String usern)
	{
		return getInstance().Recherche(usern);
	}
}
