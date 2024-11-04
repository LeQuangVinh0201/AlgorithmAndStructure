package test;

public class test3 {
	public static void print(Object... arr) {
		for(Object obj : arr) {
			System.out.print(obj + " ");
		}
	}
	
	public static void main(String[] args) {
		print("Welcome" , 2 ,1, "ok");
	}
}
