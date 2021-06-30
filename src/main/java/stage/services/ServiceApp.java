package stage.services;

import stage.models.Category;

public interface ServiceApp {
	
	
	
	public Category modifyCategory(long id, Category cat)  ; 
	public Category  findCategoryById ( long id) ; 

	


}
