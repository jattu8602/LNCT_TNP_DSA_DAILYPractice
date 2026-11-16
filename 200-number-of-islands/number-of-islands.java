class Solution {
    int[] r = {-1, 0, +1, 0 };
    int[] c = {0 , +1, 0 , -1};
            //    up left down right

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0 ; 
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n ; i++){
            for(int j = 0 ;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    count++;
                    dfs(grid, vis , n , m , i , j );
                
                }
            }
        }
        return count;
        
        
    }
    public void dfs(char[][] grid , 
    boolean[][] vis , int n , int m , 
    int row , int col){
        vis[row][col] = true;
        for(int i = 0 ; i<4;i++){
            int nr = row+r[i];
            int nc = col+c[i];
            if(nr<0 || nc<0 || nr>=n || nc>=m){
                continue;
            }else if(
                grid[nr][nc]=='0' || vis[nr][nc] == true
            ){
                continue;
            }
            dfs(grid, vis , n , m , nr , nc);

        }

    }
}