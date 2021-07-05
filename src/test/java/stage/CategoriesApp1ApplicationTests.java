package stage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import stage.models.Category;
import stage.models.Product;
import stage.repositories.CategoryRepo;
import stage.repositories.ProductRepo;


@SpringBootTest
@RunWith(SpringRunner.class) 
class CategoriesApp1ApplicationTests {

	/*private CategoryRepo repoC ; 
	private ProductRepo repoP ;
	 
	  
	  @Autowired
	  public CategoriesApp1ApplicationTests(CategoryRepo repoC, ProductRepo repoP) {
		super();
		this.repoC = repoC;
		this.repoP = repoP;
	} 
	  @Test
	  void testCreateCategory () { 
		  	Category c1= new Category() ;
		  	c1.setId(1L);
		  	c1.setNom("cars");
		  	c1.setQt(100);
		  	repoC.save(c1) ; 
		  	assertNotNull(repoC.findById(1L).get()); 	
	  }
	  @Test
	  void allCategories () { 
		  List<Category> listCat =  repoC.findAll() ;
		  assertThat(listCat).size().isPositive();
		  }
	  @Test
	  void singleCategory () { 
		  Category category  = repoC.findById(1L).get() ;   
		  assertEquals(100 , category.getQt());
		
	  }
	  
	  @Test 
	 void updateCategorty () { 
		  Category c = repoC.findById(1L).get(); 
		 c.setQt(100);
		 repoC.save(c) ; 
		 assertNotEquals(10, repoC.findById(1L).get().getQt());
	  }
	  @Test
	   void deleteCategory() { 
		  repoC.deleteById(1L);
		  assertThat(repoC.existsById(1L)).isFalse() ;   }
	 
	  @Test
	   void testCreateProduct () { 
		  	Product p = new Product() ; 
		  	p.setId(1L); 
		  	p.setDisponible(true);
		  	p.setQt(100);
		  	repoP.save(p) ; 
		  
		  	assertNotNull(repoP.findById(1L).get()); 	
	  }
	  
	  @Test
	  void allProducts() { 
		  List<Product> listPro =  repoP.findAll() ;
		  assertThat(listPro).size().isPositive();
		  }
	  @Test
	  void singleProduct () { 
		  Product product= repoP.findById(1L).get() ;
		  assertEquals(100, product.getQt());
		
	  }
	  
	  @Test 
	  void updateProduct () { 
		  Product p  = repoP.findById(1L).get(); 
		 p.setQt(200);
		 repoP.save(p) ; 
		 assertNotEquals(100, repoP.findById(1L).get().getQt());
	  }
	  @Test
	   void deleteProduct() { 
		  repoP.deleteById(1L);
		  assertThat(repoP.existsById(1L)).isFalse() ;   }*/
	  
	}
