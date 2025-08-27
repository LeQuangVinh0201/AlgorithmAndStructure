package comparator.compareToInJava.Exercise1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
	String name;  // Tên
    int age;      // Tuổi
    double gpa;   // Điểm trung bình

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-10s | Age: %2d | GPA: %.2f", name, age, gpa);
    }
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", 20, 3.2),
            new Student("Binh", 22, 3.6),
            new Student("An", 22, 2.9),
            new Student("Cuong", 19, 3.8),
            new Student("An", 20, 3.6),
            new Student("Binh", 20, 3.5)
        );

        System.out.println("Dữ liệu ban đầu:");
        students.forEach(System.out::println);
        
        //Tên theo alphabet tăng dần (A → Z).
        System.out.println("---------------------------");
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(s -> System.out.println(s));
        
        //Nếu trùng tên thì tuổi giảm dần.
        System.out.println("---------------------------");
        students.sort(Comparator.comparing(Student::getName).thenComparing(Comparator.comparingInt(Student::getAge).reversed()));
        students.forEach(s -> System.out.println(s));
        
        //Nếu trùng category và name thì Price tăng dần.
        System.out.println("---------------------------");
        students.sort(Comparator.comparing(Student::getName).thenComparing(Comparator.comparingInt(Student::getAge).reversed()));
        students.forEach(s -> System.out.println(s));
        
        //Nếu trùng cả tên và tuổi thì GPA tăng dần.
        System.out.println("---------------------------");
        students.sort(Comparator.comparing(Student::getName).thenComparing(Comparator.comparingInt(Student::getAge).reversed())
        				.thenComparingDouble(Student::getGpa));
        students.forEach(s -> System.out.println(s));
    }
    
   
    
    
    
    
    
}
