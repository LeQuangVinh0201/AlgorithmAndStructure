package test;

public class test4 {
	public static int lengthOfLongestSubstring(String s) {
        int []v=new int[128];
        int ct=0,m=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i); // lấy kí tự char trong chuỗi s
            int temp = v[c]; // check xem kí tự này đã có trong v hay chưa 
            m=Math.max(m, temp); // nếu temp đã tồn tại thì cập nhật m, bạn luôn bắt đầu từ sau vị trí lặp.
            ct=Math.max(ct,i-m+1); // kiểm tra max và gắn lại nếu có thay đổi
            v[c]=i+1; // gắn giá trị cho kí tự c trong mảng v
        }
        return ct;
    }
	
	public static void main(String[] args) {
		int a = lengthOfLongestSubstring("aa");
		System.out.println(a);
	}
}
