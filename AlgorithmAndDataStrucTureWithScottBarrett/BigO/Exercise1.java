package BigO;

/*
 * The method is defined as public and static, meaning it can be accessed from any class without needing to create an instance of the class it belongs to.
   The method  returns void, meaning it will not return any value.
   The method accepts a single parameter, an integer n. The method will use this value to determine the number of items to be printed.
 */
public class Exercise1 {
	public static void printItems(int n) {
        for (int i=0; i < n ; i++ ){
            System.out.println(i);
        } 
    }

    // DO NOT CHANGE THE MAIN METHOD BELOW
    public static void main(String[] args) {
        printItems(10);
    }
}
