//95. Unique Binary Search Trees II
// By Ratna Priya

class Solution {
    List<TreeNode> result = new ArrayList<>();
    boolean[] taken;
    int n;
    int pos;
    Set<Integer> hashes = new HashSet<>();

    public List<TreeNode> generateTrees(int n) {
        this.n = n;
        taken = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (taken[i])
                throw new Error("can't be here");
            taken[i] = true;
            dfs(new TreeNode(i), 1, i);
            taken[i] = false;
        }
        return result;
    }

    void dfs(TreeNode root, int pos, int hash) {
        if (pos == n && !hashes.contains(hash)) {
            hashes.add(hash);
            result.add(root);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (taken[i])
                continue;
            taken[i] = true;
            TreeNode copy = copy(root);
            int addHash = add(copy, i, 100);
            dfs(copy, pos + 1, hash + addHash);
            taken[i] = false;
        }
    }

    TreeNode copy(TreeNode node) {
        if (node == null)
            return null;
        TreeNode cp = new TreeNode(node.val);
        cp.left = copy(node.left);
        cp.right = copy(node.right);
        return cp;
    }

    int add(TreeNode node, int val, int level) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return val * 10 * level;
            }
            return add(node.left, val, level * 100);
        }
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return val * level;
            }
            return add(node.right, val, level * 100);
        }
        throw new Error("can't be here");
    }
}
