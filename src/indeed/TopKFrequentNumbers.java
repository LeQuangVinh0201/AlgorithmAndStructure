package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TopKFrequentNumbers {
	@SuppressWarnings("unchecked")
	public List<Integer> topKFrequent(int[] nums, int k){
		List<Integer> resultArr = new ArrayList<>();
		TreeSet<Integer>[] freq = new TreeSet[nums.length + 1];
		
		for(int i=0; i < freq.length; i++) {
			freq[i] = new TreeSet<>();
		}
		
		Map<Integer, Integer> mapList = new HashMap<>();
		
		// count frequency
		for (int i = 0; i < nums.length; i++) {
			mapList.put(nums[i], mapList.getOrDefault(nums[i], 0) + 1);
		}
		
		// bucket sort
		for (Map.Entry<Integer, Integer> entry : mapList.entrySet()) {
			freq[entry.getValue()].add(entry.getKey());
		}
		
		int index = 0;
		// loop high -> low frequency
		for (int i = freq.length - 1; i > 0 && index < k ; i++) {
			for(int n : freq[i]) {
				resultArr.add(n);
				index++;
				if(index == k) {
					return resultArr;
				}
			}
		}
		
		return resultArr;
		
		// time complexity O(n)
		// space complexity O(n)
	}
}
