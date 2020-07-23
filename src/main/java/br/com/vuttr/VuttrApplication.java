package br.com.vuttr;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VuttrApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuttrApplication.class, args);

	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.vuttr")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {

		return new ApiInfo("Vuttr Tools", "Sample API of Vuttr", "1.0", "free to use",
				new springfox.documentation.service.Contact("Felipe SSCA", "www.vuttr.com.br", "felipessca@gmail.com"),
				"Api Vuttr License", "www.vuttr.com.br", Collections.emptyList());

	}

}
