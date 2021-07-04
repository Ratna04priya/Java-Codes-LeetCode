// 658 Find K Closest Elements
// By Ratna Priya

class Solution {
    
    public int binarySearch(int[] arr, int x, int start, int end) {
        
        int midIndex = (start + end)/2;
        int element = arr[midIndex];
        if(start > end) {
            System.out.println(start + " " + end);
            if(end < 0) return start;
            if(start >= arr.length) return end;
            return Math.abs(arr[start] - x) < Math.abs(arr[end] - x) ? start : end;
        }
        if(element == x) return midIndex;
        if(x < element) return binarySearch(arr, x, start, midIndex - 1);
        
        return binarySearch(arr, x, midIndex + 1, end);
        
        
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x, 0, arr.length - 1);
        while(index + 1 < arr.length && arr[index] == arr[index + 1]) { // move to the last instance of that number
            index++;
        }
     
        List<Integer> ans = new ArrayList<>();
        int start, end;
        if(index - k < 0) { // chosing the start and end index of the sliding window wisely
            start = 0;
            end = k - 1;
        } else {
            start = index - k + 1;
            end = index;
        }
        
        int sum = 0;
        
        for(int i = start; i <= end; i++) { // calculating the total distance of the window from x
            sum += Math.abs(x - arr[i]);
        }
        
        while(end + 1 < arr.length) { // chosing the correct window
            int falseSum = sum;
            falseSum -= Math.abs(arr[start] - x);
            falseSum += Math.abs(arr[end + 1] - x);
            if(falseSum < sum) { // if the next window is having less total distance from the x then we will move ahead
                falseSum = sum;
                start++;
                end++;
            } else { // breaking when on the distance is increasing with the element x on further moving the window
                break;
            }
        }
        
        for(int i = start; i <= end; i++) ans.add(arr[i]);
        
        return ans;
    }
}
