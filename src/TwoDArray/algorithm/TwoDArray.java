package TwoDArray.algorithm;

import java.util.Arrays;

//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
// link https://leetcode.com/problems/search-a-2d-matrix/description/
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	// chú ý đến phần reasign => khá quan trọng
        int c=0;
        int start=0;
        int end=matrix.length -1;
        
        //liên tục chia đôi Array vì nó được sắp xếp thứ tự tăng dần
        while(start <= end){
            int mid=(start+end)/2; // chia lấy phần nguyên
            if(matrix[mid][0] == target){
                c = mid;
                break;
            }
            if(matrix[mid][0] > target){
                end = mid; // gắn lại end mới
            }else{
                start = mid; // gắn lại start mới
            }
            
            if((end-start) <= 1){ // nếu chỉ còn 2 element thì không tiếp tục chia đôi nữa.
            	if(target >= matrix[end][0]){
            		c = end;
                    break;
                }
                c = start;
                break;
            }
        }
        
        int j = Arrays.binarySearch(matrix[c],target); // dùng hàm built-in function của Arrays
        if(j>=0){
            return true;
        }
        return false;
    }
}