package com.max.configuration;

import com.max.converter.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableJpaRepositories("com.max.dao")
@ComponentScan(basePackages = "com.max")
public class AppConfig extends WebMvcConfigurerAdapter {
    private RoleToUserProfileConverter converter;

    public AppConfig() {
    }

    @Autowired
    public AppConfig(RoleToUserProfileConverter converter) {
        this.converter = converter;
    }

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Bean
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles]
     * to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(converter);
    }

    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
