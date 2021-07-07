package stage.models;


import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.annotations.CreationTimestamp;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	private String nom ; 
	private int qt ; 
	@CreationTimestamp
	@Column( nullable = false, updatable=false)
	private Timestamp  dateofcreation ;

	
	private Timestamp dateModif ; 
	
	@OneToMany(mappedBy = "category"  , cascade=  CascadeType.REMOVE , fetch = FetchType.LAZY)
	private List<Product> products ; 
	
	
	
	


}
