package stage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.models.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
