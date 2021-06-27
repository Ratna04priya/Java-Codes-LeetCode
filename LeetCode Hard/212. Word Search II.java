// 212. Word Search II
// By Ratna Priya

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        HashSet<String> set = new HashSet<String>();
        
        for(String word : words){
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(0) && dfs(i, j, 0, word, dir, board) && !set.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }
        return new ArrayList<String>(set);
    }
    
    public static boolean dfs(int i, int j, int idx, String word, int[][] dir, char[][] board) {
       
        if(idx == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '$';
        
        boolean result = false;
        
        for(int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(dfs(x, y, idx + 1, word, dir, board)) {
                result = true;
                break;
            }
        }
        
        board[i][j] = temp;
        return result;
    }
}
