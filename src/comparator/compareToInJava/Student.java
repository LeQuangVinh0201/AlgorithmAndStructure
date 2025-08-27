package comparator.compareToInJava;

public class Student{
	private String name;
	private String address;
	
	private int age;
	
	public Student(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//compare age
//	@Override
//	public int compareTo(Student o) {
//		return Integer.compare(this.getAge(), o.getAge());
//	}
	
	//compare name
//	@Override
//	public int compareTo(Student o) {
//		return this.name.compareTo(o.getName());
//	}
	
	//compare address
//	@Override
//	public int compareTo(Student o) {
//		return this.address.compareTo(o.getAddress());
//	}
//	
	
	@Override
	public String toString() {
//		return "name : "+ name + " address : " + address + " age : " + age;
		return "%-10s %-10s %5d".formatted(name, address,  age);
	}
	
	



}
