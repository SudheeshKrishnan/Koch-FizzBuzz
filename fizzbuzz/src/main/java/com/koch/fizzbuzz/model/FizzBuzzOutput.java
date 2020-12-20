package com.koch.fizzbuzz.model;

public class FizzBuzzOutput {

	private long input;

	private String result;

	public FizzBuzzOutput() {

	}

	public FizzBuzzOutput(long input, String result) {
		super();
		this.input = input;
		this.result = result;
	}

	public long getIn() {
		return input;
	}

	public void setIn(long in) {
		this.input = in;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\"in\":" + " " + input + "," + " " + "result:" + " " + result;
	}

}
