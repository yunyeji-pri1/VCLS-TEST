package com.neonexsoft.vclstest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.neonexsoft.vclstest.interceptor.Interceptor;

@Configuration
public class Config implements WebMvcConfigurer {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer config = new TilesConfigurer();
		config.setDefinitions(new String[] {
				"/WEB-INF/tiles/tiles.xml"
		});
		config.setCheckRefresh(true);
		return config;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver tilesView = new TilesViewResolver();
		tilesView.setViewClass(TilesView.class);
		tilesView.setOrder(1);
		return tilesView;
	}
	@Autowired
	Interceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(interceptor)
	        .addPathPatterns("/**");
//	        .excludePathPatterns("/login")
//	        .excludePathPatterns("/accounts")
//	        .excludePathPatterns("public/error");
	  }

	
}
