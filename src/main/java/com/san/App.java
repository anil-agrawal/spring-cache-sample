package com.san;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.san.config.AppConfig;
import com.san.config.EhCacheConfig;

public class App {
	public static AnnotationConfigApplicationContext appContext;

	public static void main(String[] args) {
		System.out.println("Initializing Application");
		// Choose one at a time from CachingConfig or EhCacheConfig
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EhCacheConfig.class, AppConfig.class);
		appContext = ctx;
		System.out.println("Application Initialized");
		Main.main(ctx);
	}

}
