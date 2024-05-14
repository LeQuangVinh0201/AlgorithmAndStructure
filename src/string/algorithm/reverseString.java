package string.algorithm;

import java.util.Iterator;

public class reverseString {
	public static void main(String[] args) {
		String input = "ABCDFE";
		String output_1 = "";
		String output_2 = "";
		String output ="";
		
		for (int i = 0; i < input.length()/2 ; i++) {
			char temp = input.charAt(i);
			char opposite = input.charAt(input.length() - 1 - i);
			output_1 += opposite;
			output_2 = temp + output_2;
		}
		
		if(input.length() % 2 != 0) { // trường hợp độ dài là số lẻ, thì phải xử lý thằng ở chính giữa của String Input
			output = output_1 +  input.charAt(input.length()/2) + output_2;
		}else {
			output = output_1 +  output_2;
		}
		
		System.out.println(output);
	}
}
