package indeed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatMessageTracker {
	private final long minutes; 
	private final Map<String, Deque<Long>> userRequests;
	
	public ChatMessageTracker(int minutes) {
		this.minutes = minutes * 60 * 1000L;
		this.userRequests = new HashMap<>();
	}
	
	public void sendMessage(String userId) {
		long now = System.currentTimeMillis();
		userRequests.putIfAbsent(userId, new ArrayDeque<>());
		userRequests.get(userId).addLast(now);
	}
	
	public Set<String> activeUsersLastMinutes(){
		long now = System.currentTimeMillis();
		HashSet<String> resultArr = new HashSet<>(); 
		
		Iterator<Map.Entry<String, Deque<Long>>> iter = userRequests.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Deque<Long>> entry = iter.next();
			Deque<Long> deque = entry.getValue();
			
			while(!deque.isEmpty() && deque.getFirst() < now - minutes) {
				deque.pollFirst();
			}
			
			if(deque.isEmpty()) {
				iter.remove();
			}else {
				resultArr.add(entry.getKey());
			}
		}
		
		return resultArr;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
        ChatMessageTracker tracker = new ChatMessageTracker(1); // 1 phút window

        // Fake data
        tracker.sendMessage("userA"); // t=0s
        Thread.sleep(5000);           // đợi 5s
        tracker.sendMessage("userB"); // t=5s
        Thread.sleep(5000);           // đợi 5s
        tracker.sendMessage("userA"); // t=10s

        // Lấy active users trong 1 phút
        System.out.println("Active users: " + tracker.activeUsersLastMinutes()); 
        // Kết quả: [userA, userB]

        Thread.sleep(60000); // đợi 60s
        tracker.sendMessage("userC"); // t ~70s

        System.out.println("Active users: " + tracker.activeUsersLastMinutes()); 
        // Kết quả: [userC]
    }
}
