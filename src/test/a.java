package test;

import java.util.ArrayList;
import java.util.Vector;

public class a {
	public static String a = "a ";
	public String av;
	private Integer aaa;
	
	public void add() {
		int b;
		b = 2 + 3;
		System.out.println(b);
	}
	
	
	public static void main(String[] args) {
		try { 
			  
            // Creating object of ArrayList of String of 
            // size = 3 
            ArrayList<Integer> numbers 
                = new ArrayList<Integer>(15); 
  
            // adding element to Arrlist numbers 
            

            
            for (int i = 1; i < 200; i++) {
            	numbers.add(i); 
			}
  
  
            System.out.println( 
                "ArrayList numbers can now store upto 500 elements.  " + numbers.size()); 
        } 
  
        catch (NullPointerException e) { 
            System.out.println("Exception thrown : " + e); 
        }


	}
}
