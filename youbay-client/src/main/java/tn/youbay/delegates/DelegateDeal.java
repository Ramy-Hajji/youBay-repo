package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.ClientD;
import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;
import tn.youbay.services.interfaces.IEmailSenderRemote;
import tn.youbay.services.interfaces.IServiceDealRemote;
import tn.youbay.services.interfaces.IServiceProductRemote;
import tn.youbay.serviceLocator.ServiceLocator;

public class DelegateDeal 
{
	static String jndi="/youbay-ejb/ServiceDeal!tn.youbay.services.interfaces.IServiceDealRemote";
	//mail
	static String jndi2 ="/youbay-ejb/EmailSender!tn.youbay.services.interfaces.IEmailSenderRemote";
	 
	 public static IServiceDealRemote GetInstance(){
		return (IServiceDealRemote) ServiceLocator.getinstance().getProxy(jndi);
		 
	 }
	 
	 public Boolean addDeal(Deal d)
	 {
		 return GetInstance().addDeal(d);
	 }
		
	 public Boolean deleteDealById(Integer id)
	 {
		 return GetInstance().deleteDealById(id);
	 }
	 
	 public Boolean updateDeal(Deal d)
	 {
		 return GetInstance().updateDeal(d);
	 }
	 
	 public List<Deal> readAllDeals()
	 {
		 return GetInstance().readAllDeals();
	 }
	 public List<Deal> readAllSuccessfulDeals()
	 {
		 return GetInstance().readAllSuccessfulDeals();
	 }
	 public Deal findDealById(Integer id)
	 {
		 return GetInstance().findDealById(id);
	 }
	 public void enableDeal(int id)
	 {
		 GetInstance().enableDeal(id);
	 }
	 
	 public void disableDeal(int id)
	 {
		 GetInstance().disableDeal(id);
	 }
	 
	 public	Boolean creeOffreSurProduit(Product product, Deal deal)
	 {
		 return GetInstance().creeOffreSurProduit(product, deal);
	 }

	 public Boolean subscribeClientInOffre(ClientD client, Deal deal)
	 {
		 return GetInstance().subscribeClientInOffre(client, deal);
	 }

	 public List<Deal> findAllOffresByClientId(Integer id)
	 {
		 return GetInstance().findAllOffresByClientId(id);
	 }
	 
	 //mail
	 public static IEmailSenderRemote getinstance2()
	{
			return  (IEmailSenderRemote) ServiceLocator.getinstance().getProxy(jndi2);
		
	}
	 
	 public void mail(String[] to)
	 {
		 
		 getinstance2().SendMail("oussama.rekik@esprit.tn", "tigran1993", "Secret Code" , "ajoute moi des deals de ce type", to);
	 }

}
