package indeed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

public class RecordMean2 {
	
	static class Record{
        private int value;
        private long createTime;
        public Record(int value, long createTime){
            this.value = value;
            this.createTime = createTime;
        }
        public int getValue(){
            return this.value;
        }
        public long getCreateTime(){
            return this.createTime;
        }
    }
    
    
    private long WINDOW;
    private Deque<Record> recordList = new ArrayDeque<>();
    private double sum;
    private int count;
    
    public RecordMean2(long window) {
    	this.WINDOW = window;
    	this.sum = 0.0;
    	this.count = 0;
    }
     
    //private final ReentrantLock lock = new ReentrantLock(); // cho nhiều request đồng thời
    //private final LongAdder sum = new LongAdder(); phương án này dùng partition và LongAdder từ java 8 để xử lý tránh high concurrency.
    //private LongAdder sum = new LongAdder();
    //private LongAdder count = new LongAdder();
    
    long now(){
        return System.currentTimeMillis();
    };
    
    public synchronized void record(int value) {
        delElementExpired();
        
        Record record = new Record(value, now());
        recordList.addLast(record);
        count++;
        sum += value;
    }

    public synchronized double mean() {
        if(recordList.isEmpty()) return 0.0;
        
        delElementExpired();
        
        double avg = 0.0;
        if(count > 0) avg = (double) sum / count;
        return avg;
    }
    
    public void delElementExpired(){
        long currentTime = now();
        //delete record expired
        while(!recordList.isEmpty() && recordList.getFirst().getCreateTime() < (currentTime - WINDOW)){
        	count--;
        	sum -= recordList.peekFirst().getValue();
            recordList.pollFirst();
        }
    }


	public static void main(String[] args) throws InterruptedException {
		RecordMean2 sol = new RecordMean2(5*1000);
        sol.record(5); // t= 0
        Thread.sleep(5000);
        sol.record(2); // t=5
        Thread.sleep(2000);
        sol.record(4); // t =7
        Thread.sleep(4000);
        sol.record(6); // t =11
//        Thread.sleep(2000);
//        sol.record(8);

        System.out.println(sol.mean()); // ~10.0
	}
	
	// time complexity là O(1)
	// spacae complexity là O(n)

}
