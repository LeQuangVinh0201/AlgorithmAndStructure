package LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList myLinkedList = new LinkedList(0);
		
//		myLinkedList.getHead();
//		myLinkedList.getTail();
//		myLinkedList.getLength();
//		myLinkedList.append(1);
//		myLinkedList.prepend(0);
//		myLinkedList.printList();
		
//		System.out.println(myLinkedList.removeLast().value);
//		System.out.println(myLinkedList.removeLast().value);
//		System.out.println(myLinkedList.removeLast());
		
//		System.out.println(myLinkedList.removeFirst().value);
//		System.out.println(myLinkedList.removeFirst().value);
//		System.out.println(myLinkedList.removeFirst());
		
		myLinkedList.append(1);
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.printList();
		System.out.println();
		myLinkedList.reverse();;
		
//		myLinkedList.set(3, 55);
		
		myLinkedList.printList();
	}
}
