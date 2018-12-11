package br.com.alura.forum.configuration;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.alura.forum"))
					.paths(PathSelectors.ant("/api/**"))
					.build()
					.apiInfo(apiInfo())
					.globalResponseMessage(RequestMethod.GET, 
									Arrays.asList(
											new ResponseMessageBuilder()
													.code(500)
													.message("Xii! Deu erro interno no servidor.")
													.build(),
											new ResponseMessageBuilder()
													.code(403)
													.message("Forbidden! Você não pode acessar esse recurso.")
													.build(),
											new ResponseMessageBuilder()
													.code(404)
													.message("O recurso que você buscou não foi encontrado.")
													.build()
											))
				;
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Alura", "https://cursos.alura.com.br", "contato@alura.com.br");
		
		return new ApiInfoBuilder()
					.title("Alura Fórum API Documentation")
					.description("Esta é uma documentação interativa da REST API do Fórum da Alura. Tente enviar algum request")
					.version("1.0")
					.contact(contact)
					.build();
	}
	
	
}
