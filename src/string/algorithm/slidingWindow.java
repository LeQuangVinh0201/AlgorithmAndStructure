package string.algorithm;

//3. Longest Substring Without Repeating Characters
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
public class slidingWindow {
	
	public static int getLengthOfLongestSubString(String s) {
		int[] uniqueArray = new int[128];
		int maxLength = 0;
		int start = 0;
		
		for(int i=0 ; i < s.length() ; i++) {
			char c = s.charAt(i); // lấy kí tự thứ i trong chuỗi s
			int temp = uniqueArray[c]; // char tự động ép kiểu sang int, check xem c đã tồn tại trong uniqueArray hay chưa
			start = Math.max(start, temp); // check xem kí tự mới này 
			maxLength = Math.max(maxLength, i - start + 1); // i - start + 1 tính độ dài chuỗi substring
			uniqueArray[c] = i + 1; // i + 1 là vì để lấy giá vị trí sau vị trí bị lặp
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(getLengthOfLongestSubString("abcdcac"));
		System.out.println(getLengthOfLongestSubString("pwwkew"));
	}
}
