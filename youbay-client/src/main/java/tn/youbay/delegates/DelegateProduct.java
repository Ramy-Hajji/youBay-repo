package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.Product;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.IServiceProduit;


public class DelegateProduct {
	static String jndi="/youbay-ejb/ServiceProduit!tn.youbay.services.IServiceProduit";
	 
	 public static IServiceProduit GetInstance(){
		return (IServiceProduit) ServiceLocator.getinstance().getProxy(jndi);
		 
	 }
	 
	 public void activate(int id){
		 GetInstance().activate(id);
		 
	 }
		public void delete(int p){
			GetInstance().delete(p);
		}
		public List<Product> Search(String Name){
			return GetInstance().Search(Name);
		}
		public void Edit(Product p){
			GetInstance().Edit(p);
		}
		public List<Product> FindAll(){
			return GetInstance().FindAll();
			
		}

}
