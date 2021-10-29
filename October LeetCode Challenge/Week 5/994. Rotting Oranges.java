//994. Rotting Oranges
//By Ratna Priya

class Solution {
    public int orangesRotting(int[][] grid) {
     
        int i,j,n=grid.length,m=grid[0].length,ans=0,frsh=0;
        Queue<int[]> queue=new LinkedList();
        
        for(i=0;i<n;i++)
            for(j=0;j<m;j++) {
                if(grid[i][j]==2) {

                    queue.add(new int[]{i,j});  grid[i][j]=0;
                }
                else if(grid[i][j]==1)
                    frsh++;
			}
        
        while(!queue.isEmpty())  {
            
            int size=queue.size();
            while(size-->0)
            {
                int tm[]=queue.poll();
                i=tm[0];
                j=tm[1];
                if(i+1<n&&grid[i+1][j]==1) {
                    
                    queue.add(new int[]{i+1,j});  grid[i+1][j]=0; frsh--;
                }
                if(j+1<m&&grid[i][j+1]==1) {
                    
                    queue.add(new int[]{i,j+1});  grid[i][j+1]=0; frsh--;
                }
                if(i-1>=0&&grid[i-1][j]==1) {
                    
                    queue.add(new int[]{i-1,j});  grid[i-1][j]=0;  frsh--;
                }
                if(j-1>=0&&grid[i][j-1]==1) {
                    
                    queue.add(new int[]{i,j-1});  grid[i][j-1]=0;  frsh--;
                }
            }
            if(queue.size()>0)
                ans++; 
        }
        
        if(frsh>0)
            return -1;
        return ans;
    }
}
