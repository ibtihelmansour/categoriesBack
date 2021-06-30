package stage.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import stage.models.Category;
import stage.models.Product;
import stage.repositories.CategoryRepo;



@Service
public class ServiceImpl implements ServiceApp {
 
	private CategoryRepo categoryRepo ; 
	
	
	@Autowired
	public ServiceImpl(CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	

	
	public Category findCategoryById (@PathVariable("id") long id) { 
		
		Optional<Category> optCat = categoryRepo.findById(id) ; 
		Category cat ; 
		if (optCat.isPresent())  
			cat = optCat.get() ; 
		else 
			throw new NoSuchElementException("category with this id not found" )  ; 
		return cat;	
}

	public Category modifyCategory(long id, Category cat) {
		Category catInBase = this.findCategoryById(id) ; 
		if ( cat.getNom() != null)
			catInBase.setNom(cat.getNom());
		if (cat.getQt() != 0 ) 
			catInBase.setQt(cat.getQt());
		catInBase.setDateModif(new Timestamp(System.currentTimeMillis()));
		// modify products into category
		List<Product> productsInBase = catInBase.getProducts() ; 
		List<Product> products = cat.getProducts() ; 
		for (Product newPro : products) {
			for (Product oldPro : productsInBase) {
				if (newPro.getId() == oldPro.getId()) { 
					if (newPro.getProductNom() != null )
						oldPro.setProductNom(newPro.getProductNom());
					if (newPro.getQt() != 0 ) {
						oldPro.setQt(newPro.getQt());
					    oldPro.setDisponible(true);
					}
					if (newPro.getQt() == 0 ) {
						oldPro.setQt(newPro.getQt());
					    oldPro.setDisponible(false);
					}
					oldPro.setDateofmodify(new Timestamp(System.currentTimeMillis()));				}
				
			}
			
		}

		return categoryRepo.save(catInBase);
	}






	


}
