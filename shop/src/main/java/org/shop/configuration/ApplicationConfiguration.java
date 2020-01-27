package org.shop.configuration;

import org.shop.aspect.LoggerAspect;
import org.shop.configuration.post.processor.CustomBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InitializerConfiguration.class, FactoryConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor(){
        return new CustomBeanPostProcessor();
    }

    @Bean
    public LoggerAspect loggerAspect(){
        return new LoggerAspect();
    }
}
