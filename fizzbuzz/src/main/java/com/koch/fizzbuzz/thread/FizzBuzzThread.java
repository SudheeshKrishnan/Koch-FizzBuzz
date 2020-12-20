package com.koch.fizzbuzz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import com.koch.fizzbuzz.model.FizzBuzzOutput;

public class FizzBuzzThread extends RecursiveTask<List<FizzBuzzOutput>> {

	private static final long serialVersionUID = 1L;
	long low;

	long high;

	public FizzBuzzThread(long low, long high) {

		this.low = low;
		this.high = high;
	}

	public FizzBuzzThread setLow(long low) {
		this.low = low;
		return this;
	}

	public FizzBuzzThread setHigh(long high) {
		this.high = high;
		return this;
	}

	protected List<FizzBuzzOutput> compute() {

		if (high - low <= 10) {
			List<FizzBuzzOutput> list = new ArrayList<FizzBuzzOutput>();

			LongStream stream = LongStream.range(low, high + 1);
			stream.forEach(value -> {

				list.add(ComputeFizzBuzz(value));
			});
			return list;
		} else {
			long mid = low + (high - low) / 2;
			FizzBuzzThread left = new FizzBuzzThread(low, mid);
			FizzBuzzThread right = new FizzBuzzThread(mid + 1, high);
			left.fork();
			List<FizzBuzzOutput> rightResult = right.compute();
			List<FizzBuzzOutput> leftResult = left.join();

			leftResult.addAll(rightResult);

			return leftResult;
		}
	}

	protected FizzBuzzOutput ComputeFizzBuzz(long value) {

		String output = value % 15 == 0 ? "fizzbuzz"
				: (value % 3 == 0 ? "fizz" : (value % 5 == 0 ? "buzz" : String.valueOf(value)));

		return new FizzBuzzOutput(value, output);

	}

	

}
