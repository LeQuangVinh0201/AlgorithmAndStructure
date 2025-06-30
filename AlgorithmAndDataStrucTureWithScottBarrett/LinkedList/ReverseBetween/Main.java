package LinkedList.ReverseBetween;

public class Main {
	public static void main(String[] args) {
		// Create a linked list with values 1, 2, 3, 4, and 5
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
        
        System.out.println(myLinkedList.reverse(myLinkedList.getHead()).value);

        
	}
}
