//419. Battleships in a Board
//https://leetcode.com/problems/battleships-in-a-board/
/*Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2*/

class Solution {
    int count =0;
    public int countBattleships(char[][] board) {
        if(board.length == 0) return 0;
        for(int i =0; i<board.length;i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j] =='X'){
                    dfs(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] board, int i, int j){
        if(i<0|| j<0|| i>=board.length || j>=board[i].length|| board[i][j] =='.'){
            return;
        }
        
        board[i][j]='.';
        //count++;
        dfs(board, i+1,j);
        dfs(board, i,j+1);
        return;
    }
}