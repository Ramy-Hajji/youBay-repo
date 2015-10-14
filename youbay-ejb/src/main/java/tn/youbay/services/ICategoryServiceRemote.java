package tn.youbay.services;

import java.util.List;

import tn.youbay.entities.Category;

import javax.ejb.Remote;


@Remote
public interface ICategoryServiceRemote {
	
	public Boolean addCategory(Category c);
	public Boolean updateCategory(Category c);
	public Boolean deleteCategory(Category c);
	public Category findCategoryById(int CategoryId);
	public List<Category> findAllCategories();
	public List<Category> findAllCategoriesNotApproved();
}
