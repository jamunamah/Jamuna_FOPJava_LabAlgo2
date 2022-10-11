package com.greatlearning.problem2.mergesort;

public class MergeSort {

	public void implementationOfMergeSort(int[] arr) {

		System.out.println("\nCurrency denominations before sorting: ");
		printValues(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("\nCurrency denominations after sorting: ");
		printValues(arr);

	}

	public void printValues(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void mergeSort(int[] arr, int left, int right) {

		if (left < right) { // the list has atleast two elements

			// sort

			int mid = left + (right - left) / 2; // calculate the array into two halves
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			// merge

			merge(arr, left, mid, right); // merging the above both arrays
		}
	}

	public void merge(int[] arr, int left, int mid, int right) {

		int len1 = mid - left + 1; // length of the left array
		int len2 = right - mid; // length of the right array

		int[] leftArr = new int[len1]; // intitializing arrays with new lengths
		int[] rightArr = new int[len2];

		// copying the right half and left half into two arrays

		for (int i = 0; i < len1; i++) {
			leftArr[i] = arr[left + i];
		}

		for (int j = 0; j < len2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		// merging elements

		int i, j, k;

		i = 0; // loop variable for left array
		j = 0; // loop variable for right array
		k = left; // loop variable for new array

		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {

				arr[k] = leftArr[i]; // new array
				i++;

			} else {

				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}
