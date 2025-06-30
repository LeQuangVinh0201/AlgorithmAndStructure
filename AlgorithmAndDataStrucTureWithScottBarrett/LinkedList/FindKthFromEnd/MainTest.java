package LinkedList.FindKthFromEnd;

public class MainTest {

	public static void main(String[] args) {
		LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 3;
        int result = myLinkedList.findKthFromEnd(k).value;

        System.out.println(result); // Output: 3
        

        


	}

}
