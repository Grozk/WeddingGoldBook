package fr.grozk.perso.weddingapps;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
	 
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**/**")
	                        .addResourceLocations("/resources/");
		}
		
		@Bean
		public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver 
	                         = new InternalResourceViewResolver();
//			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".html");
			return viewResolver;
		}
		
		@Override
		public void configureDefaultServletHandling(
		        DefaultServletHandlerConfigurer configurer) {
		    configurer.enable();
		}
		
//		@Bean
//		public LocaleResolver localeResolver() {
//		    SessionLocaleResolver slr = new SessionLocaleResolver();
//		    slr.setDefaultLocale(Locale.FRENCH);
//		    return slr;
//		}
//		
		/**
		 * If we want to access the page with the two different locales we have to add the parameter lang to the URL in the form: /international?lang=fr
		 * If no lang parameter is present on the URL, the application will use the default locale, in our case FRENCH locale.
		 * @return
		 */
//		@Bean
//		public LocaleChangeInterceptor localeChangeInterceptor() {
//		    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//		    lci.setParamName("lang");
//		    return lci;
//		}
//
//		@Override
//		public void addInterceptors(InterceptorRegistry registry) {
//		    registry.addInterceptor(localeChangeInterceptor());
//		}
}
