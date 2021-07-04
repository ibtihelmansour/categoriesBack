package stage.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	private String productNom  ; 
	private int qt ; 
	private boolean disponible ; 
	@CreationTimestamp
	//@JsonFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.TIMESTAMP)
	@Column( nullable = false, updatable=false)
	private Timestamp dateofcreation ;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp dateofmodify ;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="category_id" , referencedColumnName = "id")
	private Category category ;
	

}
