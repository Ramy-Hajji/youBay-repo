package tn.youbay.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.youbay.dao.ClaimsDao;
import tn.youbay.entities.Claims;
import tn.youbay.services.interfaces.IClaimService;

@Stateless
public class ClaimService implements IClaimService{
	
	@EJB
	ClaimsDao cd;
	public List<Claims> ListOfClaims()
	{
		return cd.getAllClaims();
	}
	public void DeleteClaiim(Claims c)
	{
		cd.DeleteClaim(c);
	}
	public void AddClaiim(Claims c)
	{
		cd.AddClaim(c);
	}
	public List<Claims> Recherche (String usern)
	{
		return cd.Recherche(usern);
	}
	
}
