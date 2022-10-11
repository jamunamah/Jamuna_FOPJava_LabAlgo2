package com.greatlearning.problem1;

import java.util.Scanner;

public class Transaction {

	int[] transaction;
	int numberOfTargets, target, size;

	public void implementationOfTransaction() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of transaction array: ");
		size = scanner.nextInt();
		transaction = new int[size];

		System.out.println("Enter the values of the array: ");

		for (int i = 0; i < size; i++) {
			transaction[i] = scanner.nextInt();
		}

		System.out.println("Enter the total number of targets that need to be achieved: ");
		numberOfTargets = scanner.nextInt();

		while (numberOfTargets-- != 0) {
			System.out.println("Enter the value of target: ");
			target = scanner.nextInt();

			calculateTarget(target);
		}

		scanner.close();
	}

	// Method to determine whether target is achieved or not

	public void calculateTarget(int target) {

		int sum = 0;
		int flag = 0;

		for (int i = 0; i < size; i++) {
			sum = sum + transaction[i];
			if (sum >= target) {
				System.out.println("Target achieved after " + (i + 1) + " transactions");
				flag = 1;
				break;
			}
		}

		if (flag == 0) {
			System.out.println("Target is not achieved.");
		}
	}
}
