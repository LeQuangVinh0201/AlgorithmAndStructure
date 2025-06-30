package LinkedList.ReverseBetween;

public class LinkedList {

    private Node head;
    private int length;

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
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
    
    // điều kiện là vùng between này không có node nào trỏ đến head và tail.next = null, tóm lại là 1 linkedlist riêng biệt
    public Node reverse(Node head) {
		if(head == null) return null;
		
		Node prev = null;
		Node temp = head;
		
		while(temp != null) {
			Node after = temp.next;
			temp.next = prev;
			prev = temp;
			temp = after;
		}
		
		return prev;
	}

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) return;
        
        // Tạo nút giả trỏ đến head (có giải thích phía dưới)
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
        
        // Tìm previousStartNode và startNode
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
        Node startNode = previousNode.next;
        
        // Tìm endNode và nextEndNode
        Node endNode = startNode;
        for (int i = 0; i < endIndex - startIndex; i++) {
        	endNode = endNode.next;
        };
        Node nextEnd = endNode.next;
        
        //Tách vùng cần đảo ngược
        previousNode.next = null;
        endNode.next = null;
        
        // Đảo ngược vùng between
        Node reversedBetweenHead = reverse(startNode);
        
        // Nối lại danh sách
        previousNode.next = reversedBetweenHead;
        startNode.next = nextEnd;
    
        // Cập nhật head nếu cần
        head = dummyNode.next;
    };
    
    /*
     * Nếu không có nút giả, khi bạn muốn đảo ngược một vùng bao gồm phần tử đầu tiên (startIndex == 0), 
     * bạn sẽ cần xử lý riêng biệt, vì con trỏ head của danh sách cần được cập nhật sau khi đảo ngược.
     * và chỉ cần cập nhật lại head cuối cùng bằng dummyNode.next
     * Không có nút giả:
	   Khi bạn muốn thao tác với phần tử đầu tiên (1), bạn cần xử lý riêng để cập nhật con trỏ head
     * 
     * Có nút giả:
		Nút giả dummyNode trỏ đến 1: 0(dummy) -> 1 -> 2 -> 3 -> 4 -> 5.
		Sau khi đảo ngược, danh sách sẽ được nối lại dễ dàng thành 0(dummy) -> 3 -> 2 -> 1 -> 4 -> 5, 
		và bạn chỉ cần gán head = dummyNode.next.
     */
    
    
    
    
    
    
}
