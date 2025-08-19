package indeed;

public class UniqueCharacterChecker {
	public static boolean hasAllUniqueChars(String s) {
		if(s.length() == 0) return false;
		
		int[] countArr = new int[26];
		
		for(int i=0; i < s.length(); i++){
			if(countArr[s.charAt(i) - 'a'] == 1){
				return false;
			}
			countArr[s.charAt(i) - 'a']++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		boolean check = hasAllUniqueChars("abcdy");
		System.out.println(check);
	}
}
