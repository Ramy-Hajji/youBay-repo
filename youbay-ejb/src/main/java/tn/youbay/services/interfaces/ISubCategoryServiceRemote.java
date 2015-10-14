package tn.youbay.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Category;
import tn.youbay.entities.SubCategory;


@Remote
public interface ISubCategoryServiceRemote {

	public Boolean addSubCategory(SubCategory s);
	public Boolean updateSubCategory(SubCategory s);
	public Boolean deleteSubCategory(SubCategory s);
	public SubCategory findSubCategoryById(int SubCategoryId);
	public List<SubCategory> findAllSubCategories();
	public List<SubCategory> findSubCategoriesByCategory(Category category);
}
