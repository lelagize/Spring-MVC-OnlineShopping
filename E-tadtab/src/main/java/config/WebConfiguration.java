package config;

import java.util.Properties;

import javax.xml.bind.Marshaller;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tadtab.service.RestCustomerService;


@Configuration
@ComponentScan("com.tadtab")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
	        SimpleMappingExceptionResolver r =
	              new SimpleMappingExceptionResolver();
	
	        Properties mappings = new Properties();
	        mappings.setProperty("CanNotRegisterCustomer", "canNotRegisterCustomer");
	        mappings.setProperty("InvalidCreditCardException", "creditCardError");
	        mappings.setProperty("ConcurrentModificationException", "concurrentModificationException");
	
	        r.setExceptionMappings(mappings);  
	        r.setDefaultErrorView("error");    
	        r.setExceptionAttribute("ex");    
	        r.setWarnLogCategory("example.MvcLogger");   
	        return r;
	  }
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
		
	@Bean
	public ViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public RestCustomerService restCustomerService(){
		return new RestCustomerService();
	}
	
	

}
