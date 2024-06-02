package test;

public class ThrowExample {
	static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        } else {
            System.out.println("Eligible to vote");
        }
        System.out.println("tao van chay tiep");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (AssertionError e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        System.out.println("tao van chay tiep . tao la Main");
    }
}
