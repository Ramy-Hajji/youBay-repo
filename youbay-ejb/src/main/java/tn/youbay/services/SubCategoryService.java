package tn.youbay.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Category;
import tn.youbay.entities.SubCategory;

@Stateless
public class SubCategoryService implements ISubCategoryServiceRemote {

	@PersistenceContext(name="youbay")
	EntityManager em;
	
	@Override
	public Boolean addSubCategory(SubCategory s) {
		try {
			em.persist(s);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public Boolean updateSubCategory(SubCategory s) {
		
		try {
			em.merge(s);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean deleteSubCategory(SubCategory s) {
		
		try {
			em.remove(em.merge(s));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public SubCategory findSubCategoryById(int SubCategoryId) {
		SubCategory sb = null; 
				try {
					sb=em.find(SubCategory.class, SubCategoryId);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
		return sb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> findAllSubCategories() {
		Query query = em.createQuery("select s from SubCategory s");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> findSubCategoriesByCategory(Category category) {
		Query query = em.createQuery("select s from SubCategory s where s.category=:cat" );
		query.setParameter("cat", category);
		return query.getResultList();
	}

}
