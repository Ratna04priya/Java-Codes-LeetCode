//295. Find Median from Data Stream
// By Ratna Priya

class MedianFinder {
    //int num =0;
    List<Integer> a;
    
    /** initialize your data structure here. */
    public MedianFinder() {
         a = new ArrayList<>();

    }
    
    public void addNum(int num) {
        a.add(num);
        Collections.sort(a);
    }
    
    public double findMedian() {
        // getting length of list
        int num = a.size();
        if(num%2 !=0){
            double res = a.get(num/2);
            return res;
        }
        else{
            int i = a.get(num/2);
            int j = a.get((num/2)-1);
            double res = i+j;
            res = res/2;
            return res;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
