// 1275. Find Winner on a Tic Tac Toe Game
// By Ratna Priya

class Solution {

    // Initialize the board, n = 3 in this problem.
    private int[][] board;
    private int n = 3;
    
    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1;
        
        // For each move
        for (int[] move : moves){
            int row = move[0], col = move[1];

            // Mark the current move with the current playrer's id.
            board[row][col] = player;

            // If any of the winning conditions is met, return the current player's id.
            if (checkRow(row, player) ||
                checkCol(col, player) ||
                (row == col && checkDiagonal(player)) ||
                (row + col == n - 1 && checkAntiDiagonal(player))){
                return player == 1 ? "A" : "B";
            }

            // If no one wins so far, change to the other player alternatively. 
            // That is from 1 to -1, from -1 to 1.
            player *= -1;       
        }

        // If all moves are completed and there is still no result, we shall check if 
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";   
    }

    // Check if any of 4 winning conditions to see if the current player has won.
    private boolean checkRow(int row, int player){
        for (int col = 0; col < n; ++col){
            if (board[row][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkCol(int col, int player){
        for (int row = 0; row < n; ++row){
            if (board[row][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkDiagonal(int player){
        for (int row = 0; row < n; ++row){
            if (board[row][row] != player) return false;
        }
        return true;
    }
    
    private boolean checkAntiDiagonal(int player){
        for (int row = 0; row < n; ++row){
            if (board[row][n - 1 - row] != player) return false;
        }
        return true;
    }
}  
