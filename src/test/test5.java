package test;

class test5 {
	static String str;
	
	static void staticlengthmethod() {
		System.out.println(str.length());
	};
	
	public static void main(String[] args) {
		try {
			System.out.println("Truoc ngoai le");
			staticlengthmethod();
			System.out.println("Sau ngoai le");
		} catch (NullPointerException e) {
			System.out.println("Da xay ra loi");
		} finally {
			System.out.println("Trong finally");
		}
	}
}

