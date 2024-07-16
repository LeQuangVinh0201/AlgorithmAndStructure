package sorting;

import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
public class CountPairsSum {
	public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        
        while(left < right) {
        	if(nums.get(left) + nums.get(right) < target) {
        		count += right - left; //khi thỏa mãn điều kiện ở if thì khi right - 1 vẫn đúng cho đến khi right = left;
        		left++;
        	}else {
        		right--;
        	}
        }
        	
        return count;
    }
}
