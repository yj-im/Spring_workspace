package org.iclass.mvcEx;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer{

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // c:/upload 파일시스템 경로를 url 로 매핑하기 위함.
        // 개발자가 url을 정해줍니다.
        final String URL_PATH = "/upload/**";
        // 파일시스템 위치
        final String LOCATION ="file:///C:/upload/";

        //위의 2개 값을 매핑
        registry.addResourceHandler(URL_PATH)
                .addResourceLocations(LOCATION);

    }
}
