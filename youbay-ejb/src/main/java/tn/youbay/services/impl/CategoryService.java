package tn.youbay.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.youbay.entities.Category;
import tn.youbay.services.interfaces.ICategoryServiceRemote;


@Stateless
public class CategoryService implements ICategoryServiceRemote {

	@PersistenceContext(name = "youbay")
	EntityManager em;

	@Override
	public Boolean addCategory(Category c) {
		try {
			em.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean updateCategory(Category c) {

		try {
			em.merge(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean deleteCategory(Category c) {
		try {
			em.remove(em.merge(c));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Category findCategoryById(int CategoryId) {
		Category category = null;
		try {
			category = em.find(Category.class, CategoryId);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return category;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategories() {
		Query query = em
				.createQuery("select e from Category e where e.state=:o");
		query.setParameter("o", true);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategoriesNotApproved() {
		Query query = em
				.createQuery("select e from Category e where e.state=:n");
		query.setParameter("n", false);
		return query.getResultList();
	}

	
}
