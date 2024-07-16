package comparator.compareToInJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("vinh", "da nang", 15));
		list.add(new Student("bum", "da nang", 35));
		list.add(new Student("hoa", "hcm", 25));
		list.add(new Student("khanh", "ha noi", 45));
		list.add(new Student("vi", "ha noi", 45));
		list.add(new Student("thuy", "ha noi", 27));
		
		list.sort(null); // lay sorting default cua object Student
		list.forEach(System.out::println);
		
		
		System.out.println("\nDanh sách sau khi đảo ngược thứ tự (list đã được sort ở phía trên):");
		Collections.reverse(list);
		list.forEach(System.out::println);
		
		System.out.println("\n Xáo trộn phần tử:");
		Collections.shuffle(list);
		list.forEach(System.out::println);
		
		System.out.println("\n sorting with lamda : ");
		list.sort((o1,o2) -> Integer.compare(o1.getAge(), o2.getAge())); //truyền 1 comparator vào bằng lamda
		list.forEach(System.out::println);
	}

}
