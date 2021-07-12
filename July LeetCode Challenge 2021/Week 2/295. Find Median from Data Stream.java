//295. Find Median from Data Stream
//By Ratna Priya

class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
		// if maxheap is empty or has top more than num, add num to it, else append to min heap
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        
        if (maxHeap.size() > minHeap.size() + 1) {
			// if length of maxheap is one more than minheap, add numbers from maxheap to minheap to balance
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
			// Else balance minheap if it has more numbers than maxheap
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        
		// if no numbers are present
        if (maxHeap.size() == 0) {
            return 0;
        }
		// if length of stream is even until now
        if (maxHeap.size() == minHeap.size()) {
            return (((double) maxHeap.peek() + (double) minHeap.peek())) / 2;
        }
		// if odd return top of maxheap as it contains one element extra than minheap
        return maxHeap.peek();
    }
}
