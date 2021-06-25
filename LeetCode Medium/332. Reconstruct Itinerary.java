// 332. Reconstruct Itinerary
// By Ratna Priya


// PriorityQueue HashMap + DFS Solution (Topological Sort)
// 1. Build Adjcent graph with HashMap to store <node, neighbors in min heap> pair
// 2. DFS for topological sort
//    1) Poll neighbors from the min heap
//    2) Add to first after do DFS to explore the neighbors. 
// Note 1: The order in which the nodes are added to the list is the reverse order of the final results.
//        Because the dead end should be put at the end the path.
//        So we need to reverse the result to get the Topological Sort. 
// Note 2: Use PriorityQueue as min heap to get the smaller lexical order when multiple solutions.
//        So that we can explore smaller lexical node first.
// Time complexity: O(NlogN)
// Space complexity: O(N)

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) return new ArrayList<>(); // or throw exception
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        List<String> res = new ArrayList<>();
        dfs("JFK", graph, res);
        Collections.reverse(res);
        return res;
    }
    
    private void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            String neighbor = neighbors.poll();
            dfs(neighbor, graph, res);
        }
        res.add(node);
    }
    
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>(tickets.size());
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            PriorityQueue<String> neighbors = graph.getOrDefault(from, new PriorityQueue<>());
            if (neighbors.isEmpty()) {
                graph.put(from, neighbors);
            }
            neighbors.add(to);
        }
        return graph;
    }
}
