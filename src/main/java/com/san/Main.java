package com.san;

import org.springframework.context.ApplicationContext;

import com.san.service.OperationService;

public class Main {

	static OperationService operationService;

	public static void main(ApplicationContext appContext) {
		operationService = appContext.getBean(OperationService.class);

		int x = 7, y = 3;
		System.out.println("\n\nGoing to calculate sum of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Sum of " + x + " & " + y + " is : " + operationService.sum(x, y));

		System.out.println("\n\nGoing to calculate sum of " + x + " & " + y);
		System.out.println("As result is already cached for params " + x + " & " + y + ", function will return cached result withount invoking method.");
		System.out.println("Sum of " + x + " & " + y + " is : " + operationService.sum(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate sum of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Sum of " + x + " & " + y + " is : " + operationService.sum(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate subtraction of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Subtraction of " + x + " & " + y + " is : " + operationService.sub(x, y));

		x = 3;
		y = 5;
		System.out.println("\n\nGoing to calculate subtraction of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Subtraction of " + x + " & " + y + " is : " + operationService.sub(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate subtraction of " + x + " & " + y);
		System.out.println("As result is already cached for params " + x + " & " + y + ", function will return cached result withount invoking method.");
		System.out.println("Subtraction of " + x + " & " + y + " is : " + operationService.sub(x, y));

		x = 3;
		y = 5;
		System.out.println("\n\nGoing to calculate subtraction of " + x + " & " + y);
		System.out.println("As result is cached on specific condition only (here false for " + x + " & " + y + ") , so function will return result after invoking method.");
		System.out.println("Subtraction of " + x + " & " + y + " is : " + operationService.sub(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate division of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Division of " + x + " & " + y + " is : " + operationService.div(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate division of " + x + " & " + y);
		System.out.println("As result is already cached for params " + x + " & " + y + ", function will return cached result withount invoking method.");
		System.out.println("Division of " + x + " & " + y + " is : " + operationService.div(x, y));

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to evict result of division of " + x + " & " + y);
		operationService.evictDiv(x, y);

		x = 8;
		y = 3;
		System.out.println("\n\nGoing to calculate division of " + x + " & " + y);
		System.out.println("As result is evicted from cache for params " + x + " & " + y + ", function will return cached result after invoking method.");
		System.out.println("Division of " + x + " & " + y + " is : " + operationService.div(x, y));

		x = 3;
		y = 5;
		System.out.println("\n\nGoing to calculate multiplication of " + x + " & " + y);
		System.out.println("As result is not cached for params " + x + " & " + y + " yet, function will return result after invoking method.");
		System.out.println("Multiplication of " + x + " & " + y + " is : " + operationService.mul(x, y));

		x = 3;
		y = 5;
		System.out.println("\n\nGoing to calculate multiplication of " + x + " & " + y);
		System.out.println("As result is already cached for params " + x + " & " + y + ", function will return cached result withount invoking method.");
		System.out.println("Multiplication of " + x + " & " + y + " is : " + operationService.mul(x, y));

		System.out.println("\n\nGoing to sleep for 11 seconds. If Cache is configured for Time to Live = 10 seconds, result will be evicted automatically from cache.");
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
		}

		x = 3;
		y = 5;
		System.out.println("\n\nGoing to calculate multiplication of " + x + " & " + y);
		System.out.println("As result is evicted from cache for params " + x + " & " + y + " after 10 seconds, function will return cached result after invoking method.");
		System.out.println("Division of " + x + " & " + y + " is : " + operationService.mul(x, y));

	}
}
