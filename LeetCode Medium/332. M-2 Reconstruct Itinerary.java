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
