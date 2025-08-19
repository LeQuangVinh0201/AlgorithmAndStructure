package indeed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class APIRateLimiter {
	private final int maxRequests;
	private final long windowMillis;
	private final Map<String, Deque<Long>> userRequests;
	
	public APIRateLimiter(int maxRequests, int windowMinutes) {
		this.maxRequests = maxRequests;
		this.windowMillis = windowMinutes * 60 * 1000L;
		this.userRequests = new HashMap<>();
	}
	
	public boolean allowRequest(String userId) {
		long now = System.currentTimeMillis();
		
		//initialize deque for user if not exist
		userRequests.putIfAbsent(userId, new ArrayDeque<>());
		Deque<Long> requests = userRequests.get(userId);
		
		// delete request expired
		while(!requests.isEmpty() && requests.getFirst() <= (now - windowMillis)) {
			requests.pollFirst();
		}
		
		// check limit request and add request into deque
		if(requests.size() < maxRequests) {
			requests.addLast(now);
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		APIRateLimiter limiter = new APIRateLimiter(3, 1);
		
		System.out.println(limiter.allowRequest("userA"));// true 
		Thread.sleep(10000);
		System.out.println(limiter.allowRequest("userA"));// true
		Thread.sleep(10000);
		System.out.println(limiter.allowRequest("userA"));// true 
		Thread.sleep(10000);
		System.out.println(limiter.allowRequest("userA"));// false => exceed max request
		Thread.sleep(40000);
		System.out.println(limiter.allowRequest("userA")); // old request expired
	}
}
