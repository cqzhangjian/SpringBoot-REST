package org.zj.sp.rest.spzjrestdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

	
	 @Bean
	    public Docket alipayApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("用户API接口文档")  
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("org.zj.sp.rest.spzjrestdemo.user.controller"))
	                .paths(PathSelectors.any()).build();
	    }
	    
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("用户服务")
	                .description("用户服务接口")
	                .termsOfServiceUrl("https://www.jianshu.com/u/d775c518e5ba")
	                .contact(new Contact("联系方式 ", "https://www.jianshu.com/u/d775c518e5ba", "93414020@qq.com"))
	                .version("1.0").build();
	    }
	
}
