package tn.youbay.services;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Claims;

@Remote
public interface IClaimService {
	public List<Claims> ListOfClaims();
	public void DeleteClaiim(Claims c);
	public void AddClaiim(Claims c);
	public List<Claims> Recherche (String usern);
}
