class Solution {
    int[] r = {-1, 0 , +1, 0};
    int[] c = {0 , +1, 0 , -1};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalParameter = 0 ;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    totalParameter +=dfs(grid, vis, n , m , i , j);

                }
            }
        }
        return totalParameter;
        
}
public int dfs(int[][] grid, boolean[][] vis, int n , int m , int row , int col){
    vis[row][col]=true; 
    int parameter = 0 ; 
    for(int i = 0 ; i<4; i++){
        int nr = row + r[i];
        int nc = col +c[i];
        if(nr<0 || nc<0 || nr>=n || nc>=m){
            parameter++;
        }else if(grid[nr][nc]==0){
            parameter++;

        }else if(!vis[nr][nc]){
            parameter+=dfs(grid, vis, n , m , nr , nc);
        }
    }
    return parameter;

}





}