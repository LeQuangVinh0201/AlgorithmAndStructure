package comparator.compareToInJava.Exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class test1 {
	public static void main(String[] args) {
		//Mô tả: Cho một List<Integer>, hãy sắp xếp danh sách này theo thứ tự tăng dần.
		List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2);
		numbers.sort((a,b) -> (a- b));
		System.out.println(numbers);
		
		//List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2);
		List<String> names = Arrays.asList("John", "Alice", "Bob", "Zara");
		names.sort(null);
//		names.sort(Comparator.reverseOrder());
		System.out.println(names);
		
//		Bài 3: Sắp xếp danh sách chuỗi theo độ dài tăng dần
		System.out.println("----------------");
		names.sort(Comparator.comparingInt(String::length));
		System.out.println(names);
		
		
//		Bài 4: Sắp xếp danh sách đối tượng theo một trường cụ thể
//		class Person { String name; int age; }
//		Yêu cầu: Sắp xếp List<Person> theo:
//		- Tên theo thứ tự từ điển.
//		- Tuổi tăng dần.
//		- Tuổi giảm dần, nếu trùng tuổi thì theo tên.
		List<Person> people = new ArrayList<>();
        // Thêm 5 dữ liệu ảo bằng add()
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 28));
        people.add(new Person("Eve", 30));
        people.add(new Person("Vinh", 30));
        
        //- Tên theo thứ tự từ điển.
        people.sort(Comparator.comparing(Person::getName));
        System.out.println(people);
        
      //- Tuổi tăng dần
        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println(people);
        
        //- Tuổi giảm dần, nếu trùng tuổi thì theo tên.
        System.out.println("----------------");
        Comparator<Person> byAgeDesc = Comparator.comparingInt(Person::getAge).reversed();
        Comparator<Person> byNameDesc = Comparator.comparing(Person::getName).reversed();
        people.sort(byAgeDesc.thenComparing(byNameDesc));
        System.out.println(people);
        
        
//      Bài 5: Sắp xếp Map theo key
//      Cho Map<String, Integer> → sắp xếp theo key chữ cái tăng dần.
        Map<String, Integer> sales = new HashMap<>();
        sales.put("March", 120);
        sales.put("January", 150);
        sales.put("May", 100);
        sales.put("April", 130);
        sales.put("February", 140);
        
        // cách 1 dùng TreeMap
        Map<String, Integer> sortedMap = new TreeMap<>(sales);
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("----------------");
        
        // cách 2 dùng stream
        sales.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        
        System.out.println("----------------");
        //Bài 6: Sắp xếp Map theo value giảm dần
        //Sắp xếp Map theo value giảm dần
        sales.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
       
        System.out.println("----------------");
        //Bài 7: Sắp xếp Set thành List rồi sắp xếp
        Set<String> setList = new HashSet<>();
        setList.add("ba");
        setList.add("dccc");
        setList.add("cee");
        setList.add("adddddddd");
        
        List<String> list = new ArrayList<>(setList);
        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(list);
        
        
//        Bài 8: Sắp xếp danh sách nhiều tiêu chí
//        class Product { String name; double price; int quantity; }
//        Sắp xếp Product theo:
//        1. Giá tăng dần.
//        2. Nếu trùng giá thì ưu tiên số lượng nhiều hơn.
//        8.1
        ArrayList<Product> productList = new ArrayList<>();

        // Thêm 5 sản phẩm giả lập
        productList.add(new Product("Laptop", 1200.0, 5));
        productList.add(new Product("Phone", 800.0, 10));
        productList.add(new Product("Tablet", 500.0, 7));
        productList.add(new Product("Monitor", 300.0, 3));
        productList.add(new Product("Monitor2", 300.0, 13));
        productList.add(new Product("Keyboard", 50.0, 20));
        
//        1. Giá tăng dần.
        System.out.println("----------------");
        productList.sort((a,b) -> Double.compare(a.getPrice(), b.getPrice()));
        System.out.println(productList);
        
//        2. Nếu trùng giá thì ưu tiên số lượng nhiều hơn.
        System.out.println("----------------");
        productList.sort(Comparator.comparingDouble(Product::getPrice).thenComparing(Comparator.comparingInt(Product::getQuantity).reversed()));
        System.out.println(productList);
	}
}
