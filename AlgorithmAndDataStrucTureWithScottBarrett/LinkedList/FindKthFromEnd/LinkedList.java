package LinkedList.FindKthFromEnd;

public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

	public Node findKthFromEnd(int k){
	    int length = 0;
	    Node start = head;
	    Node temp = head;
	    if(start == null) return null;
	    while(start != null){
	        length++;
	        start = start.next;
	        if(length > k){ // Nếu khoảng cách giữa start và temp đã bằng k thì move temp song song với start (luôn giữ khoảng cách cho đến hết vòng loop)
	            temp = temp.next;
	        }
	    }
	    if(k > length) return null;
	    return temp;
	}

}


