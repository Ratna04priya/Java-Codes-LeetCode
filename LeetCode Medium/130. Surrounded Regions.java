//130. Surrounded Regions
//By Ratna Priya

class Solution {
    public void solve(char[][] grid) {
         if(grid.length == 0)
            return;
        int row = grid.length, col = grid[0].length;
        
        //first row and last row
        for(int i=0; i<row; i++){
            dfs(grid, i, 0);
            dfs(grid, i, col-1);
        }
        //first col and last col
        for(int j=1; j<col-1; j++){
            dfs(grid, 0, j);
            dfs(grid, row-1, j);
        }
        
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                if (grid[i][j] == 'O') grid[i][j] = 'X';
                else if (grid[i][j] == '1') grid[i][j] = 'O';
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0|| j<0|| i>=grid.length|| j>=grid[i].length || grid[i][j]== 'X'||grid[i][j]=='1')
            return;
        
        grid[i][j] = '1';
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);
        
    }
}
