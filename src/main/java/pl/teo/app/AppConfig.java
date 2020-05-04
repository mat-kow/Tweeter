package pl.teo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("pl.teo")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories (basePackages = "pl.teo.repository")
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory (){
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("tweeterPersistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager (EntityManagerFactory emf){
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix("");
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    public ViewResolver resourceBundleViewResolver(){
        ResourceBundleViewResolver resourceBundleViewResolver = new ResourceBundleViewResolver();
        resourceBundleViewResolver.setBasename("views");
        resourceBundleViewResolver.setOrder(0);
        return resourceBundleViewResolver;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/WEB-INF/resources/**").addResourceLocations("/resources/");
    }

}
