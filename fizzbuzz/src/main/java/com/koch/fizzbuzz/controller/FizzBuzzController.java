package com.koch.fizzbuzz.controller;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koch.fizzbuzz.model.FizzBuzzOutput;
import com.koch.fizzbuzz.thread.FizzBuzzThread;

@RestController
@Validated
public class FizzBuzzController {
	private final long MAX_VALUE = 4294967295L; // pow(2,32)-1

	@GetMapping(path = "/fizzbuzz", produces = { "application/json" })
	ResponseEntity<List<FizzBuzzOutput>> studentR(@RequestParam("low") @Min(0) Long low,
			@RequestParam("high") @Max(MAX_VALUE) Long high) {

		if (low >= high)
			throw new RuntimeException("Lower limit should be less than upper limit");
		else {

			int nThreads = Runtime.getRuntime().availableProcessors();

			ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
			List<FizzBuzzOutput> result = forkJoinPool.invoke(new FizzBuzzThread(low, high));

			return ResponseEntity.ok(result);
		}
	}

}
