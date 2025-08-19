package indeed;

public class LongestSubstringWithoutRepeat {
	public static int lengthOfLongestSubString(String s) {
		int[] uniqueArray = new int[128];
		int left = 0;
		int maxLength = 0;
		
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			int temp = uniqueArray[c];
			left = Math.max(left, temp); // if temp > left => duplicate character
			maxLength = Math.max(maxLength, right - left +1);
			uniqueArray[c] = right + 1; // update duplicate character position, +1 => left position if has duplicate for next loop 
		}
		
		return maxLength;
		// time complexity O(n)
		// space complexity O(1)
	}
	
	public static void main(String[] args) {
		int length = lengthOfLongestSubString("abcdxheacd");
		System.out.println(length);
	}
}
