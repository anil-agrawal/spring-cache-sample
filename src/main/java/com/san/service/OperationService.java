package com.san.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class OperationService {

	// Cache all results
	@Cacheable(value = "operation-sum-cache")
	public int sum(int x, int y) {
		System.out.println("Method OperationService.sum(" + x + "," + y + ") invoked.");
		return x + y;
	}

	// Cache results only if x > y
	@Cacheable(value = "operation-sub-cache", condition = "#x > #y")
	public int sub(int x, int y) {
		System.out.println("Method OperationService.sub(" + x + "," + y + ") invoked.");
		return x - y;
	}

	// Cache all results
	// timeToLiveSeconds = 10 when EHCache is used instead of ConcurrentMapCache
	@Cacheable(value = "operation-mul-cache")
	public int mul(int x, int y) {
		System.out.println("Method OperationService.mul(" + x + "," + y + ") invoked.");
		return x * y;
	}

	// Cache all results
	@Cacheable(value = "operation-div-cache")
	public float div(int x, int y) {
		System.out.println("Method OperationService.div(" + x + "," + y + ") invoked.");
		return x / y;
	}

	// Evict result from cache
	@CacheEvict(value = "operation-div-cache")
	public void evictDiv(int x, int y) {
		System.out.println("Method OperationService.evictDiv(" + x + "," + y + ") invoked.");
	}

}
