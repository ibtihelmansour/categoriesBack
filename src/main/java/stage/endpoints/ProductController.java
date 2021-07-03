package stage.endpoints;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stage.dto.ProductDto;
import stage.models.Product;
import stage.repositories.ProductRepo;




@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	

	private final ProductRepo repo ; 
 
	

	@Autowired
	public ProductController(ProductRepo repo ) {
	
	
		this.repo = repo;
	}
	
	@GetMapping
	public List<Product> allProduct () { 
		return repo.findAll() ; 
 	}
	@DeleteMapping("delete/{id}")
	public Product deleteProduct(@PathVariable("id") long id ) { 
	   Product  product = this.findById(id) ; 
		repo.deleteById(id);
		return product; 
	
	}
	
	
	@GetMapping("/{id}")
	public Product findById ( @PathVariable("id") long id) { 
		Optional<Product> optPro = repo.findById(id) ; 
		Product product ; 
		if (optPro.isPresent())
			product = optPro.get() ; 
		else 
			throw new NoSuchElementException("product with this id is not found" ) ; 
		
		return product ;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/{id}")
	public Product modifProduct ( @PathVariable("id") long id , @RequestBody ProductDto productdto) { 
		 
		   Product product2 = this.findById(id) ; 
		    product2.setDateofmodify(new Timestamp(System.currentTimeMillis()));
			if (productdto.getProductNom() != null) 
				product2.setProductNom(productdto.getProductNom() );
			if( productdto.getQt() > 0 ) { 
				product2.setQt(productdto.getQt()) ; 
			    product2.setDisponible(true);
			}else {
				  product2.setQt(0) ; 
				  product2.setDisponible(false);
			}
			  
						
		return 	repo.save(product2) ;
		
	}
	

	

}

	
	
	

