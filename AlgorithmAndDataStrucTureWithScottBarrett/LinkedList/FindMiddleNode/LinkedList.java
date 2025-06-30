package LinkedList.FindMiddleNode;

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
    
    //Cách Vinh tự nghĩ ra vẫn đúng, nhưng dài hơn
	public Node findMiddleNode2(){
	    if(head == null) return null;
	    Node slowPoint = head;
	    Node fastPoint = head;
	    
	    int count = 0;
	    int length = 1;
	    while(fastPoint.next != null){
	        fastPoint = fastPoint.next;
	        count ++;
	        length++;
	        if(count == 2){
	            slowPoint = slowPoint.next;
	            count = 0;
	        }
	    }
	    
	    if(length % 2 != 0){
	        return slowPoint;
	    }else{
	        return slowPoint.next;
	    }
	}
	
	// guideline của course, rất hay.  also known as Floyd's Tortoise and Hare algorithm, Thuật toán Rùa và Thỏ
	public Node findMiddleNode() {
	    Node slow = head;
	    Node fast = head;
 
	    while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
	    }
 
	    return slow;
	}

}


