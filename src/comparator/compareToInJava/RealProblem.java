package comparator.compareToInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// LG interview
// compare dành cho kiểu Object
public class RealProblem {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<Student> list = new ArrayList<>();

		list.add(new Student("vinh", "da nang", 15));
		list.add(new Student("bum", "da nang", 35));
		list.add(new Student("bum", "da nang", 13));
		list.add(new Student("bum", "da nang", 26));
		list.add(new Student("hoa", "hcm", 25));
		list.add(new Student("khanh", "ha noi", 45));
		list.add(new Student("vi", "ha noi", 45));
		list.add(new Student("thuy", "ha noi", 27));
		
		Map<String, List<Student>> hashMap = new HashMap<>();
		
		hashMap = list.stream().collect(Collectors.groupingBy(Student::getAddress)); // cách này lọc các List<Student> có chung địa chỉ nhanh hơn cách dưới
		
//		for (Student student : list) {
//			if(hashMap.containsKey(student.getAddress())) {
//				hashMap.get(student.getAddress()).add(student);
//			}else{
//				List<Student> subList = new ArrayList<>();
//				subList.add(student);
//				hashMap.put(student.getAddress(), subList);
//			};
//		};
		
		// nên dùng cách này cho Object => ngắn gọn dễ hiểu
		List<List<Student>> resultList = new ArrayList<>();
		for (Map.Entry<String, List<Student>> entry : hashMap.entrySet()) {
			entry.getValue().sort(Comparator.comparing(Student::getName).thenComparingInt(Student::getAge));
			System.out.println(entry.getKey() + "--- " + entry.getValue());
			resultList.add(entry.getValue());
		};
		
		System.out.println("--------------- ------------------");
		resultList.forEach(e -> e.forEach(System.out::println));
		
		long endTime = System.currentTimeMillis();
		//thời gian chạy đoạn code trên là :
		System.out.println((double) (endTime - startTime)/ 1000);
	}
}
