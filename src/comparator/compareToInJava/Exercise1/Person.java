package comparator.compareToInJava.Exercise1;

public class Person {
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
    public String toString() {
        return name + " (" + age + ")";
    }
	
	
	
}
