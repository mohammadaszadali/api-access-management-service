package com.dtag.bmp.service.api.access_management;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.*")
@EnableAutoConfiguration(exclude = { HypermediaAutoConfiguration.class })
@EnableMongoRepositories(value = { "com.*" })
@EnableAsync
public class Application {
	@Value("${apiVersion}")
	private String apiVersion;

	private static String adapterType;

	public static String getAdapterType() {
		return adapterType;
	}

	public static void setAdapterType(String adapterType) {
		Application.adapterType = adapterType;
	}

	public static void main(String[] args) throws JsonProcessingException {

		if (args.length != 0) {
			Application.setAdapterType(args[0]);

		} else {
			Application.setAdapterType("DAO");
		}

		SpringApplication.run(Application.class, args);

	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Userapi").apiInfo(apiInfo()).select()
				.paths(regex("/apiaccess/.*")).build().directModelSubstitute(XMLGregorianCalendar.class, MixIn.class);
	}

	public static interface MixIn {
		@JsonIgnore
		public void setYear(int year);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API access Management REST APIs").description("API access Management REST APIs")
				.termsOfServiceUrl("http://....").contact("TechMahindra").license("TechMahindra Licensed")
				.licenseUrl("https://techmahindra.com").version(apiVersion).build();
	}
	
	  @Bean
	  public RestTemplate restTemplate() {
		    return new RestTemplate();
		}
	 
	/*
	 * @Bean public RestTemplateAdaptor injectHelperAdapter() throws Exception{
	 * return new RestTemplateAdaptor(); }
	 */
	  

}
