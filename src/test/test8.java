package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test8 {
	public void finalize() {
        System.out.println("object is garbage collected");
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		System.out.println(list);
		
		char ch = 'a';
        int ascii = ch;
        System.out.println(ascii);
        System.out.println("-------------");
        int[] arr1 = {1,2,3,6,4,2,45,6,7,89,5};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        
        String[] arr2 = {"c", "d", "a"};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        
        System.out.println("-------------");
        System.out.println(105 - 'a');
        	
        
        test8 s1 = new test8();
        test8 s2 = new test8();
        s1 = null;
        s2 = null;
        System.gc();
        
        List<String> lista = new LinkedList<>();

	}
}
