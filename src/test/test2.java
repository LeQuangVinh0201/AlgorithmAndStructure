package test;

interface Animal {
    void eat();

    // Phương thức mặc định
    default void sleep() {
        System.out.println("Animal sleeps");
    }
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    // Không cần phải cài đặt phương thức sleep(), sử dụng cài đặt mặc định
    
}

public class test2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();   // Output: Dog eats
        dog.sleep(); // Output: Animal sleeps
    }
}



