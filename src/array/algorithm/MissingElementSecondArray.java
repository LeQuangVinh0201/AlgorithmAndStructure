package array.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingElementSecondArray {
	// Find elements which are present in first array and not in second
	// Given two arrays, the task is that we find numbers which are present in first
	// array, but not present in the second array.
	// input : a[] = {1, 2, 3, 4, 5, 10};
	// b[] = {2, 3, 1, 0, 5};
	// Output : 4 10
	// and n > m
	
	
	// first way
	static void findMissing(int a[], int b[], int n, int m) {
		for (int i = 0; i < n; i++) {
			int j;

			for (j = 0; j < m; j++) {
				if (a[i] == b[j]) {
					break; // if a include an element of b, break => sure j < m => a[i] is duplicate with b[j] 
				}
			}

			if (j == m) { // if a[i] is not included in b => print it out
				System.out.print(a[i] + " ");
			}
		}
	}
	
	// second way
	static List<Integer> findMissing2(ArrayList<Integer> a, ArrayList<Integer> b ){
		List<Integer> c = new ArrayList<>(a);
		c.removeAll(b);
		return c;
	}

	public static void main(String[] args) {
		List<Integer>  a = Arrays.asList( 1, 2, 6 );
		List<Integer>  b = Arrays.asList( 2, 4 );
		
		
		// first way
//		int n = a.length;
//		int m = b.length;
//		findMissing(a, b, n, m);
		
		
		// second way
		List<Integer> c = new ArrayList<>(a);
		c.removeAll(b);
		
		
		
		
		// third way
		List<Integer> collect = a.stream().filter(element -> !b.contains(element)).collect(Collectors.toList());
		
		for (Integer item : collect) {
			System.out.println(item);
		}
		
		int testArray[] = {1,3,5};
		List<Integer> list2 = Arrays.stream(testArray).boxed().collect(Collectors.toList()); // from java 8
		
		List<Integer> list = Arrays.stream(testArray).boxed().toList(); // from java 16
		
		
		
	}
}

