package stage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class BeanConfig {
	// factory Method to create Bean
	@Bean
	
	public ModelMapper getModelMapper() {
		return new ModelMapper() ; 
	}
}