//174. Dungeon Game
//By Ratna Priya

class Solution {
    int minPower = Integer.MIN_VALUE;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == m-1 && j == n-1)
                    dungeon[i][j] = dungeon[i][j] > 0 ? 0 : dungeon[i][j];
                else if (i == m-1)
                    dungeon[i][j] += dungeon[i][j+1];
                else if (j == n-1)
                    dungeon[i][j] += dungeon[i+1][j];
                else
                    dungeon[i][j] += Math.max(dungeon[i+1][j], dungeon[i][j+1]);
                if (dungeon[i][j] > 0)
                    dungeon[i][j] = 0;
            }
        }

        return Math.max(1, 1-dungeon[0][0]);
    }
