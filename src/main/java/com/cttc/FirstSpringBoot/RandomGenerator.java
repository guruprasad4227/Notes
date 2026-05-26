package com.cttc.FirstSpringBoot;

import java.util.Random;

public class RandomGenerator {

	public static void main(String[] args) {
		Random r = new Random();
		int nextInt = r.nextInt(900000) + 100000;
		System.out.println(nextInt);
	}
}
