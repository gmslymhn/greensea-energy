package greensea.energy.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SwaggerConfig
 * @Description: 整合knife4j
 * @Author: gmslymhn
 * knife4j是一个集成Swagger的增强解决方案 核心为文档说明和在线调试功能
 * 免去了开发过程中写接口文档的痛苦
 * @CreateTime: 2024-05-18 11:09
 * @Version: 1.0
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("格熙新能源云平台")
                        .description("格熙新能源云平台API文档")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("外部文档")
                        .url("https://springshop.wiki.github.org/docs"));
    }

}