package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void bubleSort(int[] array) {
		int temp = 0;
		for(int i=0; i < array.length; i++) {
			for(int j= 0; j < array.length - 1 -i; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		System.out.println("New Array : " + Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] array = {5,2,47,48,7852,1,-1,15,66,8,9,67,-15};
		bubleSort(array);
	}
}
