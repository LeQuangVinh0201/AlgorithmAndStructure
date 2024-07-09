package test;

import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
        // Tạo một PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Thêm phần tử vào PriorityQueue
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(4);

        // In ra các phần tử của PriorityQueue
        System.out.println("PriorityQueue: " + pq);

        // Lấy phần tử có độ ưu tiên cao nhất (phần tử nhỏ nhất)
        System.out.println("Phần tử có độ ưu tiên cao nhất: " + pq.peek());

        // Lấy và loại bỏ phần tử có độ ưu tiên cao nhất
        System.out.println("Lấy và loại bỏ phần tử: " + pq.poll());

        // In ra các phần tử còn lại của PriorityQueue
        System.out.println("PriorityQueue sau khi loại bỏ phần tử: " + pq);
    }
}
