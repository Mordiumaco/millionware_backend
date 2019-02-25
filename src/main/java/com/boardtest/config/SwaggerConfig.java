package com.boardtest.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		Contact contactInfo = new Contact("Jae Hyeon Choi", "https://github.com/Mordiumaco" ,"mordiumaco@gmail.com");
		
		ApiInfo info = new ApiInfo("Board for testing MillionWare", "밀리언웨어 제출용 게시판 백엔드", "1.0.0.ver", "http://localhost:8081/", contactInfo, "MIT", "https://opensource.org/licenses/MIT", Collections.emptyList());
		
		List<ResponseMessage> responseMessages = new ArrayList<>();
		
		responseMessages.add(new ResponseMessageBuilder().code(500).message("message about 500").build());
		responseMessages.add(new ResponseMessageBuilder().code(400).message("message about 400").build());
		
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("million").apiInfo(info).useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, responseMessages).select().apis(RequestHandlerSelectors.basePackage("com.boardtest.controller"))
				.paths(PathSelectors.any()).build();
		
	}
}
