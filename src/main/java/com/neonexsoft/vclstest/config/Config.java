package com.neonexsoft.vclstest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class Config {
	
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
}
