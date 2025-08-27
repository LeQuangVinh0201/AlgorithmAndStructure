package indeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class StreamDuplicate {


	// --------- Định nghĩa Stream -----------
    interface Stream {
        boolean hasNext();
        int next();
    }

    // Entry trong heap: (giá trị, streamId)
    static class StreamEntry {
        int value;
        int streamId;
        StreamEntry(int value, int streamId) {
            this.value = value;
            this.streamId = streamId;
        }
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getStreamId() {
			return streamId;
		}
		public void setStreamId(int streamId) {
			this.streamId = streamId;
		}
    }

    public List<Integer> solution(List<Stream> streams, int numToAgree) {
        List<Integer> result = new ArrayList<>();
        // Min-heap so sánh theo value
        PriorityQueue<StreamEntry> pq = new PriorityQueue<>(Comparator.comparingInt(StreamEntry::getValue));

        // B1: nạp phần tử đầu tiên của mỗi stream vào heap
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).hasNext()) {
                pq.offer(new StreamEntry(streams.get(i).next(), i));
            }
        }

        // B2: xử lý heap
        while (!pq.isEmpty()) {
            int currentVal = pq.peek().value;    // giá trị nhỏ nhất hiện tại
            Set<Integer> seenStreams = new HashSet<>();

            // Gom tất cả entry có giá trị == currentVal
            while (!pq.isEmpty() && pq.peek().value == currentVal) {  //Retrieves, but does not remove, the head of this queue
                StreamEntry entry = pq.poll(); // Retrieves and removes the head of this queue
                seenStreams.add(entry.streamId);

                // nạp phần tử tiếp theo của stream này vào heap
                if (streams.get(entry.streamId).hasNext()) {
                    pq.offer(new StreamEntry(streams.get(entry.streamId).next(), entry.streamId));
                }
            }

            // Nếu số stream chứa currentVal ≥ numToAgree → đưa vào kết quả
            if (seenStreams.size() >= numToAgree) {
                result.add(currentVal);
            }
        }

        return result;
    }

    // --------- Test ----------
    public static void main(String[] args) {
    	StreamDuplicate m = new StreamDuplicate();

        // Stream đơn giản từ List<Integer>
        class ListStream implements Stream {
            Iterator<Integer> it;
            ListStream(List<Integer> data) { it = data.iterator(); }
            public boolean hasNext() { return it.hasNext(); }
            public int next() { return it.next(); }
        }

        List<Stream> streams = Arrays.asList(
            new ListStream(Arrays.asList(1, 1, 3, 3, 7, 8, 9, 9, 11)),
            new ListStream(Arrays.asList(0, 1, 4, 5, 6, 8, 9)),
            new ListStream(Arrays.asList(0, 1, 4, 5, 8, 8, 9, 34))
        );

        List<Integer> res = m.solution(streams, 2);
        System.out.println(res); // [0, 1, 4, 5, 8, 9]

    }
    
}
