package stage.endpoints;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import stage.dto.CategoryDto;
import stage.dto.ProductDto;
import stage.models.Category;
import stage.models.Product;
import stage.repositories.CategoryRepo;
import stage.repositories.ProductRepo;
import stage.services.ServiceImpl;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/categories")
public class CategoryController {
	
	
	private ServiceImpl service  ;
	private final CategoryRepo repo ;
	private final ProductRepo repoProduct ; 
	private ModelMapper mapper ; 
	

	@Autowired
	public CategoryController(ServiceImpl service ,  CategoryRepo repo , ProductRepo repoProduct , ModelMapper mapper) {
		super();
		this.mapper = mapper ; 
		this.service = service;
		this.repo = repo ;
		this.repoProduct = repoProduct; 
	} 
	
	
	
	@GetMapping	
	public List<Category> getAllCategories () { 
		return repo.findAll() ; 
	}
	
	@GetMapping("/{id}")
	public Category findCategoryById (@PathVariable("id") long id) { 
		
		return service.findCategoryById(id);	
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/add")
	public Category createNewCategory (@RequestBody CategoryDto category1 ) { 
	    Category categorie = mapper.map(category1, Category.class) ; 
	

		return repo.save(categorie) ;
		
	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/deletecat/{id}")
	public Category deleteCategory( @PathVariable("id") long id) { 
		  Category cat = this.findCategoryById(id) ; 
		  repo.deleteById(id);
		return cat; 
	}
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/updateCat/{id}") 
	public Category modifyCategory (@PathVariable("id") long id , @RequestBody CategoryDto category) { 
		Category categorie = mapper.map(category, Category.class) ; 
		return service.modifyCategory(id, categorie) ; 
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addProduct/{idCat}")
	public Product createProductByCategory (@PathVariable("idCat") long idcat ,@RequestBody ProductDto productdto) { 
		Category category = this.findCategoryById(idcat) ; 
		Product product = mapper.map(productdto, Product.class) ; 
		product.setCategory(category);
		product.setDateofmodify(null);
		if (product.getQt() > 0 ) {
			product.setDisponible(true);
		}else {
			 product.setDisponible(false);
		}

		repoProduct.save(product) ; 
		return product  ; 
	}
		
	@GetMapping ("/products/{id}")
	public List<Product> allProductsByCat ( @PathVariable("id") long id ) { 
		
		List<Product> products = repoProduct.findAll() ; 
		List<Product> productsBycat= new ArrayList<>() ; 
		
		for (Product product : products) {
			if ( product.getCategory() != null && product.getCategory().getId() == id) {
				
					productsBycat.add(product) ; 	
			}
		}
		return productsBycat ; 
	}

	

}
