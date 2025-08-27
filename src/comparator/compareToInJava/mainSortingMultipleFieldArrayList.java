package comparator.compareToInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class mainSortingMultipleFieldArrayList {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("vinh", "da nang", 15));
		list.add(new Student("bum", "da nang", 35));
		list.add(new Student("bum", "da nang", 13));
		list.add(new Student("bum", "da nang", 26));
		list.add(new Student("hoa", "hcm", 25));
		list.add(new Student("khanh", "ha noi", 45));
		list.add(new Student("vi", "ha noi", 45));
		list.add(new Student("thuy", "ha noi", 27));
		
		
		//cách 1 tạo lớp anonymous class implement interface Comparator, cái này có thể viết 1 lớp cụ thể riêng implement Comparator
		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (o1.getName() + o1.getAge()).compareTo(o2.getName() + o2.getAge());
			}
		});
		list.forEach(System.out::println);
		System.out.println("----------------------");
		
		//cach 2 dùng sort của ArrayList
		list.sort((o1 , o2) -> (o1.getName() + o1.getAge()).compareTo(o2.getName() + o2.getAge()));
		list.forEach(System.out::println);
		System.out.println("----------------------");
		
		//cach 3 dùng sort của lớp Collections
		Collections.sort(list, (o1 , o2) -> (o1.getName() + o1.getAge()).compareTo(o2.getName() + o2.getAge()));
		list.forEach(System.out::println);
		System.out.println("----------------------");
		
		//cách 4 dùng lamda (method reference) => cách này ngắn nhất
		list.sort(Comparator.comparing(Student::getName).thenComparingInt(Student::getAge));
		list.forEach(System.out::println);
		System.out.println("----------------------");
		
		//cách 5 dùng Stream API => cách này cũng được nhưng dài hơn cách 4, có thể kết hợp với filter trước, hoặc có những logic trước đó
		List<Student> sortedList = list.stream().sorted(Comparator.comparing(Student::getName).thenComparingInt(Student::getAge)) 
												.collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		System.out.println("---------------------- 666");
		
		Comparator<Student> sortByNameAsc = Comparator.comparing(Student::getName);
		Comparator<Student> sortByAgeDesc = Comparator.comparing(Student::getAge).reversed();
		list.sort(sortByNameAsc.thenComparing(sortByAgeDesc));
		list.forEach(System.out::println);
		
	}
}
