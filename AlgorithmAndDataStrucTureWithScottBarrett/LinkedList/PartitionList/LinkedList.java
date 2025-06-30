package LinkedList.PartitionList;

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
            System.out.print(temp.value + " ");
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
        if (head == null) {
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
    
    //code Vinh tu code
    public void partitionList1(int x){
        Node lessHead = null;
        Node greaterHead = null;
        if(head == null) return;
        if(head.value >= x){
        	lessHead = null;
            greaterHead = head;
        }else{
            lessHead = head;
            greaterHead = null;
        }
        Node temp = head.next;
        Node lessHeadTemp = lessHead;
        Node greaterHeadTemp = greaterHead;
        
        while(temp != null){
            if(temp.value >= x){
                if(greaterHeadTemp == null){
                    greaterHeadTemp = temp;
                    greaterHead = temp;
                }else{
                    greaterHeadTemp.next = temp; 
                    greaterHeadTemp = temp;
                }
            }else{
                if(lessHeadTemp == null){
                    lessHeadTemp = temp;
                    lessHead = temp;
                }else{
                    lessHeadTemp.next = temp;
                    lessHeadTemp = temp;
                }
            }
            temp = temp.next;
        }
        
        if(greaterHeadTemp != null){
            greaterHeadTemp.next = null;
        }
        
        if(lessHeadTemp != null && greaterHead != null){
            lessHeadTemp.next = greaterHead;
        }
        
        if(lessHead == null){
        	lessHead = greaterHead;
        }
        
        head = lessHead;
    }
    
    // Cách này của khách nhanh hơn vì tạo new dummy với value = 0
    // Cách này có ưu điểm là chúng ta không cần phải xem nốt đầu tiên của less và greater có = null hay không
    // Sau khi traverse thì họ chỉ lấy dummy.next => đỡ phải if else như code của Vinh ở trên
    // Cơ bản là giống nhau như dài dòng hơn
    public void partitionList(int x) {
        if (head == null) return;
 
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
 
        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
 
        prev2.next = null;
        prev1.next = dummy2.next;
 
        head = dummy1.next;
    }  
    
    
    

}


