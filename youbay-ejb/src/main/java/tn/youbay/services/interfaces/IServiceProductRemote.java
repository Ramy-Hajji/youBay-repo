package tn.youbay.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;
import tn.youbay.entities.Provider;

@Remote
public interface IServiceProductRemote
{
	Boolean addProduct(Product pdt);
	
	Boolean addProductOnProvider(Product product,Provider provider);

	Boolean deleteProductById(Integer id);

	Boolean updateProduct(Product pdt);

	List<Product> readAllProducts();
	
	List<Product> findAllProductsByProviderId(Integer id);

	Product findProductById(Integer id);
}
