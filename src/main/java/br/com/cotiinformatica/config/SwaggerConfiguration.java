package br.com.cotiinformatica.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //classe de configuração do Spring
@EnableSwagger2 //habilitando o swagger
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.cotiinformatica"))
                .paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo());		
	}	
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "ECommerce - Loja de produtos", 
	      "Sistema desenvolvido em JAVA SpringBoot API / Hibernate JPA.", 
	      "Versão 1.0 - 22/07/2021", 
	      "http://www.walacelima.com", 
	      new Contact("Tradicao Brasill System", "http://www.walacelima.com", 
	    		  	"contato@walacelima.com"), 
	      			"License of API", "http://www.walacelima.com", 
	      			Collections.emptyList());
	}	
}
