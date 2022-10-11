package com.greatlearning.problem2.currency;

import java.util.Scanner;

import com.greatlearning.problem2.mergesort.MergeSort;

public class Currency {

	public void currencyPayment() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations: ");
		int sizeOfCurrencyDenominations = scanner.nextInt();

		System.out.println("Enter the currency denominations value (should be greater than 0): ");
		int[] currencyDenominations = new int[sizeOfCurrencyDenominations];

		for (int i = 0; i < sizeOfCurrencyDenominations; i++) {
			currencyDenominations[i] = scanner.nextInt();
		}

		// Sort the data in ascending order

		MergeSort mergeSort = new MergeSort();
		mergeSort.implementationOfMergeSort(currencyDenominations);

		System.out.println();
		System.out.println("\nEnter the amount you want to pay: ");
		int amount = scanner.nextInt();
		System.out.println();

		currencyCount(amount, currencyDenominations);
		scanner.close();

	}

	public void currencyCount(int amount, int[] currencyDenominations) {

		int[] noteCounter = new int[currencyDenominations.length]; // array to store the count of each denomination

		for (int i = currencyDenominations.length - 1; i >= 0; i--) {

			if (amount >= currencyDenominations[i]) {

				noteCounter[i] = amount / currencyDenominations[i];
				amount = amount - (noteCounter[i] * currencyDenominations[i]);
			}
		}

		if (amount > 0) {
			System.out.println("Exact amount cannot be given in the current denomination.");
		}

		if (amount == 0) {
			System.out.println("Your payment approach in order to give minimum number of notes will be: ");
			for (int i = currencyDenominations.length - 1; i >= 0; i--) {
				if (noteCounter[i] != 0) {
					System.out.println(currencyDenominations[i] + ":" + noteCounter[i]);
				}
			}
		}
	}
}
