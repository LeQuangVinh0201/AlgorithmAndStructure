package comparator.compareToInJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sortingWithArrayList {
	public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        
        // cách 1 sử dụng lớp Collections
//        Collections.sort(list);
//        System.out.println(list); // Output: [1, 1, 3, 4, 5]
//        System.out.println("----------------------");
        
        // cách 2 sử dụng sort() của ArrayList
//        list.sort(null); // Equivalent to Collections.sort(list)
//        System.out.println(list); // Output: [1, 1, 3, 4, 5]
//        System.out.println("----------------------");
        
        // cách 3 sử dụng Comparator 
//        Collections.sort(list, new Comparator<Integer>() { // đây là anonymous class implement Interface Comparator =>  mục đích để không  phải viết lớp cụ thể
//        	@Override
//        	public int compare(Integer o1, Integer o2) {
//        		return o2 - o1;
//        	}
//        });
//        System.out.println(list); // Output: [5, 4, 3, 1, 1]
//        System.out.println("----------------------");
        
        // cách 4, truyền 1 Comparator bằng cách dùng lamda từ java 8
//        list.sort((o1, o2) -> o2 - o1); // Sắp xếp giảm dần
//        System.out.println(list); // Output: [5, 4, 3, 1, 1]
//        System.out.println("----------------------");
        
        // cách 5, dùng stream từ java 8
        List<Integer> sortedList = list.stream()
						               .sorted()
						               .collect(Collectors.toList());
        System.out.println(sortedList); // Output: [1, 1, 3, 4, 5]
        
        // Tóm lại nên dùng cách 4 hoặc 5 => ngắn gọn và dễ hiểu
    }
}
