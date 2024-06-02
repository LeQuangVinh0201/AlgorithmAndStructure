package test;

import java.util.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Alice", 31));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        System.out.println("Sắp xếp theo tên:");
        Collections.sort(people, new NameComparator());
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("\nSắp xếp theo tuổi:");
        Collections.sort(people, new AgeComparator());
        for (Person person : people) {
            System.out.println(person);
        }
        
        System.out.println("\nSắp xếp theo tên và tuổi:");
        Collections.sort(people, new NameAndAgeComparator());
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

class NameAndAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
         return (p1.getName() + p1.getAge()).compareTo(p2.getName() + p2.getAge());
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}


