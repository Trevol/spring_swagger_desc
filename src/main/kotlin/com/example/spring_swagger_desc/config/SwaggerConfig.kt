package com.example.spring_swagger_desc.config

import com.example.spring_swagger_desc.entities.Entity1
import com.example.spring_swagger_desc.entities.Entity2
import com.fasterxml.classmate.TypeResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig : WebMvcConfigurationSupport() {
    @Bean
    fun productApi(): Docket {
        val typeResolver = TypeResolver()
        return Docket(DocumentationType.SWAGGER_2)
            .additionalModels(
                typeResolver.resolve(Entity1::class.java),
                typeResolver.resolve(Entity2::class.java)
            )
            .select().apis(RequestHandlerSelectors.basePackage("com.example.spring_swagger_desc.controllers"))
            .paths(PathSelectors.regex("/meter.*"))
            .build()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }
}