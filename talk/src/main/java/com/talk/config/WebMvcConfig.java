package com.talk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${uploadPath}")
	String uploadPath;

	// 실제 업로드 경로와 웹에서 사용하는 경로(주소)를 연결, 
//	실제 업로드 경로는 웹에서 사용할 수 없는 경로이기 때문에 웹용으로 /files를 쓰겠다고 등록
//	웹에서 /files/12345.jpg라는 이미지요청이 들어오면 
//	실제 경로는 C:/talkimage/12345.jps의 이미지를 제공한다.
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry ) {
		registry.addResourceHandler("/files/**").addResourceLocations(uploadPath);
	}
	
	
//	WebMvcConfigurer 인터페이스는 Spring MVC설정을 사용자(개발자)정의하기 위해 사용
	
//	- 리소스 핸들러 설정 : 정적 리소스(css, javascript, 이미지, 파일 등)에 대한 
//	경로를 설정하고 캐싱정책을 적용한다
	
//	- CORS : Cross-Origin Resource Sharing
//			다른 도메인(주소-url)에서 현재 도메인(주소-url)으로 API요청 허용하도록 설정
	
//	뷰 컨트롤러 등록 : URL요청에 대해 뷰이름을 직접 매핑,
//						컨트롤러 없이 뷰를 반환할 수 있음
	
//	경로 패턴 설정 : URL경로 패턴을 설정
	
	
	
}
