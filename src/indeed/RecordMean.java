package indeed;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecordMean {
	
	// Your old code in text has been preserved below.
	// 
//	                     should return (5 + 14 + 11) / 3 = 10
//	                    /           - should return ?  (14 + 11) / 2 = 12.5
	// record(12)   record(5)   record(14)   record(11)   mean()   mean()
//	     |            |           |           |          |        |
//	     -------------------------------------> time
//	     |========= 5 min window =========|
//	                 |========= 5 min window =========|

//	public class Solution {
//	    static final long WINDOW = 5*60*1000; // 5 minutes in ms
//
//	    // provided; returns current time in milliseconds since epoch, eg. 1606368629
//	    // Note: do not implement this
//	    long now();
//
//	    public void record(int value) {
//	        // Candidate TODOstat
//	    }
//
//	    public double mean() {
//	        // Candidate TODO
//	    }
//	}
	
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
    
    
    
    static final long WINDOW = 5*60*1000;
    private Deque<Record> recordList = new ArrayDeque<>();
     
    
    long now(){
        return System.currentTimeMillis();
    };
    
    public void record(int value) {
        delElementExpired();
        
        Record record = new Record(value, now());
        recordList.addLast(record);
    }

    public double mean() {
        if(recordList.isEmpty()) return 0.0;
        
        delElementExpired();
        
        return recordList.stream().mapToLong(Record::getValue).average().orElse(0.0);
    }
    
    public void delElementExpired(){
        long currentTime = now();
        //delete record expired
        while(!recordList.isEmpty() && recordList.getFirst().getCreateTime() < (currentTime - WINDOW)){
            recordList.pollFirst();
        }
    }
	
	
	


	public static void main(String[] args) throws InterruptedException {
		RecordMean sol = new RecordMean();
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
	
	// time complexity là O(n)
	// spacae complexity là O(n)
}
