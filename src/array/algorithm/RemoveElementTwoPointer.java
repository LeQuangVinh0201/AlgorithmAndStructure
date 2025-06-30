package array.algorithm;

public class RemoveElementTwoPointer {
	public int removeElement(int[] nums, int val) {
        int j = 0;

        for(int i=0; i< nums.length; i++) {
        	if(nums[i] != val) {
        		// vì không cần quan tâm đến phần cuối của nums, nên ta chỉ cần đè lên là được
        		nums[j] = nums[i];
        		j++;
        	}
        }
        
        return j;
    }
	
	public int removeElementTwoPointer(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        
        while(i <= j) {
        	//nếu nums[i] bằng val thì dịch trái 1 đơn vị
        	if(nums[i] != val) {
        		i++;
        	}else {
        		//nếu nums[i] không bằng val thì dịch phải 1 đơn vị
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		j--;
        	}
        }
        return i;
    }
}
