package tn.youbay.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.ClientD;
import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;


@Remote
public interface IServiceDealRemote
{
	Boolean addDeal(Deal d);

	Boolean deleteDealById(Integer id);

	Boolean updateDeal(Deal d);

	List<Deal> readAllDeals();
	
	List<Deal> readAllSuccessfulDeals();

	Deal findDealById(Integer id);
	
	void enableDeal(int id);
	
	void disableDeal(int id);

	Boolean creeOffreSurProduit(Product product, Deal deal);

	Boolean subscribeClientInOffre(ClientD client, Deal deal);

	List<Deal> findAllOffresByClientId(Integer id);
}
