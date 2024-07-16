package comparator.compareToInJava;

import java.util.Arrays;
import java.util.Comparator;

public class sortArray {
	public static void main(String[] args) {
        int[] arr = {5, 2, 8, 14, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        System.out.println("-------------");
        int[] sortedArray = Arrays.stream(arr)
        						  .sorted()
        						  .toArray();
        System.out.println(Arrays.toString(sortedArray));
        
        //có 2 cách sort 1 array tĩnh
        // 1. dùng Arrays.sort ( có thể có comparator)
        // 2. dùng stream
        // 3. dùng comparator với điều kiện phần tử có type là kiểu object
        
        System.out.println("-------------");
        String[] arr3 = {"apple", "orange", "banana", "kiwi"};
        Arrays.sort(arr3, (a,b) -> a.compareTo(b)); // dung lam da để tạo 1 comparator, chỉ dùng được với kiểu Object. String cũng là object
        System.out.println(Arrays.toString(arr3));
        
        
        System.out.println("-------------");
        // mảng 2 chiều
        int diem[][] = { {5, 6}, {4, 2}, {3, 2}, {3, 3}, {3, 5},{3, 4},{4, 3}};
        Arrays.sort(diem, (a, b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]) ); // đang so sánh theo chiều x, nếu muốn so sánh chiều y thì là a[1]
        System.out.println(Arrays.deepToString(diem));
        
        System.out.println("-------------");
        Arrays.sort(diem, (a, b) -> Integer.compare(a[1], b[1])); //  so sánh chiều y thì là a[1]
        System.out.println(Arrays.deepToString(diem));
        
        System.out.println("-------------");
        int aaa = Arrays.binarySearch(arr, 8);
        System.out.println(aaa);
        
        
    }
}
