//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-cache-sample
//Module						: spring-cache-sample
//Package Name					: com.san.config
//File Name						: EhCacheConfig.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 22-May-2018 12:44:49 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//22-May-2018   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
public class EhCacheConfig {

	@Bean
	public EhCacheManagerFactoryBean ehCahceFactory() {
		EhCacheManagerFactoryBean ehCache = new EhCacheManagerFactoryBean();
		ehCache.setConfigLocation(new ClassPathResource("ehcache.xml"));
		ehCache.setCacheManagerName("applicationCacheManager");
		// ehCache.setShared(true);
		// ehCache.setAcceptExisting(true);
		return ehCache;
	}

	@Bean
	public EhCacheCacheManager cachceManager(EhCacheManagerFactoryBean ehCahceFactory) {
		System.out.println("Cache manager is EhCacheCacheManager");
		EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
		CacheManager manager = ehCahceFactory.getObject();
		ehCacheCacheManager.setCacheManager(manager);
		return ehCacheCacheManager;
	}
}
