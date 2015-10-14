package tn.youbay.delegates;

import java.util.List;

import tn.youbay.entities.Category;
import tn.youbay.serviceLocator.ServiceLocator;
import tn.youbay.services.ICategoryServiceRemote;



public class CategoryDelegate {

	private static final String jndi = "/youbay-ejb/CategoryService!tn.youbay.services.ICategoryServiceRemote";

	private static ICategoryServiceRemote getProxy() {

		return (ICategoryServiceRemote) ServiceLocator.getinstance().getProxy(jndi);
	}

	public static Boolean doAddCategory(Category c) {
		return getProxy().addCategory(c);
	}

	public static Boolean doupdateCategory(Category c) {
		return getProxy().updateCategory(c);
	}

	public static Boolean dodeleteCategory(Category c) {
		return getProxy().deleteCategory(c);
	}

	public static Category dofindCategoryById(int CategoryId) {
		return getProxy().findCategoryById(CategoryId);
	}

	public static List<Category> dofindAllCategories() {
		return getProxy().findAllCategories();
	}

	public static List<Category> dofindAllCategoriesNotApproved() {
		return getProxy().findAllCategoriesNotApproved();
	}
	

}
