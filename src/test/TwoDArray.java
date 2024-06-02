package test;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int c=0;
        int start=0;
        int end=matrix.length -1;
        while(start <= end){
            int mid=(start+end)/2;
            if(matrix[mid][0] == target){
                c = mid;
                break;
            }
            if(matrix[mid][0] > target){
                end = mid;
            }else{
                start = mid;
            }
            if((end-start) <= 1){
            	
            	if(target >= matrix[end][0]){
            		c = end;
                    break;
                }
                c = start;
                break;
            }
        }
        
        int j = Arrays.binarySearch(matrix[c],target);
        if(j>=0){
            return true;
        }
        return false;
    }
}