// 1029. Two City Scheduling - https://gist.github.com/SuryaPratapK/fb23eed83c65754519797904aa12dc93
//By Ratna Priya

class Profit{
    int[] cost;
    int profit;
    public Profit(int[] cost, int profit){
        this.cost = cost;
        this.profit = profit;
    }
}
class comparator implements Comparator<Profit>{
    public int compare(Profit a, Profit b){
        return b.profit - a.profit;
    }
}
class Solution {
    // how much we more benifit if we go to city a rather than city b
    // find the profits
    // construct a max heap (based on profits)
    // first half people will go City A
    // and other half will go to City B
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Profit> pq = new PriorityQueue<>(new comparator());
        int n = costs.length;
        for(int i=0;i<n;i++){
            pq.add(new Profit(costs[i], costs[i][1]-costs[i][0]));
        }
        int min_cost = 0;
        for(int i=0;i<n;i++){
            if(i< (n/2))
                min_cost+=pq.poll().cost[0]; // visit city A
            else
                min_cost+=pq.poll().cost[1]; // visit city B
        }
        return min_cost;
    }
}
