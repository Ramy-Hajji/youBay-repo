package tn.youbay.delegates;


import java.util.List;

import tn.youbay.entities.Category;
import tn.youbay.entities.SubCategory;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.ISubCategoryServiceRemote;


public class SubCategoryDelegate {
private static final String jndi = "/youbay-ejb/SubCategoryService!tn.youbay.services.ISubCategoryServiceRemote";
	
	private static ISubCategoryServiceRemote getProxy(){
		
		return (ISubCategoryServiceRemote) ServiceLocator.getinstance().getProxy(jndi);
	}
	
	public static Boolean doaddSubCategory(SubCategory s){
		return getProxy().addSubCategory(s);
		
	}
	public static Boolean doupdateSubCategory(SubCategory s){
		return getProxy().updateSubCategory(s);
		
	}
	public static Boolean dodeleteSubCategory(SubCategory s){
		return getProxy().deleteSubCategory(s);
	}
	public static SubCategory dofindSubCategoryById(int SubCategoryId){
		return getProxy().findSubCategoryById(SubCategoryId);
	}
	public static List<SubCategory> dofindAllSubCategories(){
		return getProxy().findAllSubCategories();
	}
	public static List<SubCategory> dofindSubCategoriesByCategory(Category Category){
		return getProxy().findSubCategoriesByCategory(Category);
	}

}
