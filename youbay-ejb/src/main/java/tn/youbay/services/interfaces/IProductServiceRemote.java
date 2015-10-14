package tn.youbay.services.interfaces;

import java.util.List;





import javax.ejb.Remote;

import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;

@Remote
public interface IProductServiceRemote {
	
	public Boolean addProduct(Product p);
	public Boolean updateProduct(Product p);
	public Boolean deleteProduct(Product p);
	public Product findProductById(int ProductId);
	public List<Product> findAllProducts();
	public List<Product> findProductsBySubCategory(SubCategory SubCategory);
	public List<Product> findProductsByCategory(Category category);

}
