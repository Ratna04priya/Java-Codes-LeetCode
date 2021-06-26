// 332. Reconstruct Itinerary - Using method 2: hashmap and priority queue.
// By Ratna Priya

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> i: tickets)
            map.computeIfAbsent(i.get(0), k -> new PriorityQueue<>()).add(i.get(1));
        Stack<String> st = new Stack<>();
        List<String> ans = new ArrayList<>();
        st.add("JFK");
        while (!st.empty()) {
            while ( map.containsKey(st.peek()) && !map.get(st.peek()).isEmpty() ) {
                st.push(map.get(st.peek()).poll());
            }
            ans.add(0, st.pop());
        }
        return ans;
    }
}

/*
This is the variation of dfs.
The way to tweak the dfs is to not to put a base condition and let the dfs fill and tsack and empty itslef
What i mean by this is 

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Lets say we built a graph of this and its adjacenecy list look like this:-
JFK - MUC
MUC - LHR
LHR - SFO
SFO - SJC

So when we perform a dfs on JFK

|        |
|        |
|        |   <-----Recursion Stack
|        |
|__JFK___|

We explore JFKs neighbors 

|        |
|        |
|        |
|  MUC   |
|__JFK___|

We explore Muc neighbors

|        |
|        |
|  LHR   |
|  MUC   |
|__JFK___|

|        |
|  SFO   |
|  LHR   |
|  MUC   |
|__JFK___|

|  SJC   |
|  SFO   |
|  LHR   |
|  MUC   |
|__JFK___|

Since SJC has no neighbors we pus it back to the answer

|        |
|  SFO   |      ans=SJC
|  LHR   |
|  MUC   |
|__JFK___|

|        |
|        |      ans=SJC,SFO
|  LHR   |
|  MUC   |
|__JFK___|

|        |
|        |      ans=SJC,SFO,LHR
|        |
|  MUC   |
|__JFK___|


|        |
|        |      ans=SJC,SFO,LHR,MUC 
|        |
|        |
|__JFK___|

|        |
|        |      ans=SJC,SFO,LHR,MUC,JFK 
|        |
|        |
|________|

Print in reverse order
*/
