package stage.models;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


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
	//@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	//@Temporal(TemporalType.TIMESTAMP)
	@Column( nullable = false, updatable=false)
	private Timestamp  dateofcreation ;

	
    //@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp dateModif ; 
	
	@OneToMany(mappedBy = "category"  , cascade=  CascadeType.REMOVE , fetch = FetchType.LAZY)
	private List<Product> products ; 
	
	
	
	


}
