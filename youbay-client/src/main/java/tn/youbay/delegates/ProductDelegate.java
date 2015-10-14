package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.IProductServiceRemote;


public class ProductDelegate {
	
private static final String jndi = "/youbay-ejb/ProductService!tn.youbay.services.IProductServiceRemote";
	
	private static IProductServiceRemote getProxy(){
		
		return (IProductServiceRemote) ServiceLocator.getinstance().getProxy(jndi);
	}
	
	public static Boolean doaddProduct(Product p){
		return getProxy().addProduct(p);
	}
	public static Boolean doupdateProduct(Product p){
		return getProxy().updateProduct(p);
	}
	public static Boolean dodeleteProduct(Product p){
		return getProxy().deleteProduct(p);
	}
	public static Product dofindProductById(int ProductId){
		return getProxy().findProductById(ProductId);
	}
	public static List<Product> dofindAllProducts(){
		return getProxy().findAllProducts();
	}
	public static List<Product> dofindProductsBySubCategory(SubCategory subcategory){
		return getProxy().findProductsBySubCategory(subcategory);
	}
	public static List<Product> findProductsByCategory(Category category){
		return getProxy().findProductsByCategory(category);
	}

	
}
