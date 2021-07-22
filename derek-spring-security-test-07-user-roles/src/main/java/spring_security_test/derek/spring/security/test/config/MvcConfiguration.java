package spring_security_test.derek.spring.security.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="spring_security_test.derek.spring.security.test")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
	//@Autowired
	//private ApplicationContext applicationContext;

	//define a bean for view resolver
	@Bean
    public ViewResolver viewResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(springTemplateEngine());
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

//	@Bean
//	public SpringTemplateEngine springTemplateEngine() {
//	  SpringTemplateEngine engine = new SpringTemplateEngine();
//	  engine.setEnableSpringELCompiler(true);
//	  engine.setTemplateResolver(templateResolver());
//	  return engine;
//	}

//	@Bean
//    public SpringResourceTemplateResolver templateResolver() {
//	  SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//	  resolver.setApplicationContext(this.applicationContext);
//	  resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".html");
//	  resolver.setTemplateMode(TemplateMode.HTML);
//	  return resolver;
//	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}

//	@Bean
//	public MultipartResolver multipartResolver(){
//		return new CommonsMultipartResolver();
//	}

}
