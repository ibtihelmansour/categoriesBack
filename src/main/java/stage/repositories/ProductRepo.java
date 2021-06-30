package stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.models.Product;



@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	
}