//1235. Maximum Profit in Job Scheduling.java
//By Ratna Priya

class Solution {
    
    int[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        //approach:
        //put all in an array of arrays -> [[stTime, endTim, profit], ...]
        //sort by start times and earliest endtimes
        //loop through each entry in a recursive way
        int[][] jobs = new int[startTime.length][3];
        
        for(int i=0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        //sort this array
        Arrays.sort(jobs, (a,b) -> a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);
        
        memo = new int[startTime.length+1];
        Arrays.fill(memo, -1);
        
        return dp(0, jobs);
    }
    
    public int dp(int end, int[][] jobs) {
        
        if(end==jobs.length) {
            return 0;
        }
        
        if(memo[end] != -1)
            return memo[end];
        
        //binary search for next highest startTime
        //careful, handle condition of jobs having end time greater than any start time (inside binarySearch())
        int indexOfNextStart = binSearch(jobs[end][1], jobs);
        
        //we either consider the current job or skip it
        int currMax = Math.max(dp(end+1, jobs),
                              jobs[end][2]+dp(indexOfNextStart, jobs));
        
        memo[end] = currMax;
        return memo[end];
            
    }
    
    public int binSearch(int index, int[][] jobs) {
        
        //condition to handle jobs who have an end time greater than any start time
        if(index>jobs[jobs.length-1][0])
            return jobs.length;
        
        int left = 0;
        int right = jobs.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(jobs[mid][0] < index) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
