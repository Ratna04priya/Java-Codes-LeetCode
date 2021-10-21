//380. Insert Delete GetRandom O(1)
//By Ratna Priya

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {
    private final Random random;
    private final List<Integer> list;
    private final Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null) return false;
        fastListRemove(index);
        map.remove(val);
        return true;
    }

    /** Grab the last element and set it to the index to be removed.
     *  This avoids an expensive list.remove() since the removed element is at the tail. */
    private void fastListRemove(int index) {
        int size = list.size();
        int last = list.get(size - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(size - 1);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
