package config;

import com.tadtab.service.MessageServiceImpl;
import com.tadtab.service.ProductDao;
import com.tadtab.service.ShoppingCartService;
import com.tadtab.service.SignUpService;
import com.tadtab.service.SingInService;
import com.tadtab.validation.SignUpValidation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfiguration {

    @Bean
    public SignUpService signUpService() {
        return new SignUpService();
    }
        
    @Bean
    public  ProductDao  productDao() {
        return new  ProductDao();
    }
    
     
    @Bean
    public SingInService singInService(){
    	return new SingInService();
    }
    @Bean
    public ShoppingCartService shoppingCartService(){
    	return new ShoppingCartService(productDao());
    }
    @Bean
    public MessageServiceImpl messageServiceImpl(){
    	return new MessageServiceImpl();
    }
}
