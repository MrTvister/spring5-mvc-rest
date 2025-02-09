package guru.springfamework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {//extends WebMvcConfigurationSupport
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(springfox.documentation.builders.RequestHandlerSelectors.any())
                .paths(springfox.documentation.builders.PathSelectors.any())
                .build()
                .pathMapping("/");


    }

//        @Override
//        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("swagger-ui.html")
//                    .addResourceLocations("classpath:/META-INF/resources/");
//            registry.addResourceHandler("/webjars/**")
//                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        }
}
