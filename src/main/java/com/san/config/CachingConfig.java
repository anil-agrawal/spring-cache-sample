//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-cache-sample
//Module						: spring-cache-sample
//Package Name					: com.san.config
//File Name						: CachingConfig.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 22-May-2018 12:15:02 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//22-May-2018   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

	@Bean
	public CacheManager concurrentMapCacheManager() {
		System.out.println("Cache manager is concurrentMapCacheManager");
		return new ConcurrentMapCacheManager("operation-sum-cache", "operation-sub-cache", "operation-mul-cache", "operation-div-cache");
	}

}
