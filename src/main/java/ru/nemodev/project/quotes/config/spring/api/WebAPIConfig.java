package ru.nemodev.project.quotes.config.spring.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.nemodev.project.quotes.api.processor.AuthorRestRequestProcessor;
import ru.nemodev.project.quotes.api.processor.CategoryRestRequestProcessor;
import ru.nemodev.project.quotes.api.processor.QuoteRestRequestProcessor;
import ru.nemodev.project.quotes.config.spring.ServiceConfig;

/**
 * created by sbrf-simanov-an on 20.11.2018 - 15:35
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "ru.nemodev.project.quotes.api" })
public class WebAPIConfig
{
    private final ServiceConfig serviceConfig;
    private final EntityConverterDTOConfig entityConverterDTOConfig;

    public WebAPIConfig(ServiceConfig serviceConfig, EntityConverterDTOConfig entityConverterDTOConfig)
    {
        this.serviceConfig = serviceConfig;
        this.entityConverterDTOConfig = entityConverterDTOConfig;
    }

    @Bean
    public AuthorRestRequestProcessor authorRestRequestProcessor()
    {
        return new AuthorRestRequestProcessor(serviceConfig.authorServiceImpl(), entityConverterDTOConfig.authorToDTOConverter());
    }

    @Bean
    public CategoryRestRequestProcessor categoryRestRequestProcessor()
    {
        return new CategoryRestRequestProcessor(serviceConfig.categoryServiceImpl(), entityConverterDTOConfig.categoryToDTOConverter());
    }

    @Bean
    public QuoteRestRequestProcessor quoteRestRequestProcessor()
    {
        return new QuoteRestRequestProcessor(serviceConfig.quoteServiceImpl(), entityConverterDTOConfig.quoteToDTOConverter());
    }
}
