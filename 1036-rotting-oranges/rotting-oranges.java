class Solution {
    class Pair{
        int row , col , tm;
        Pair(int row , int col, int tm ){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }

    }


    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        // here i m setting the zero level of the rotten oranges
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i , j , 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;

                }
                if(grid[i][j]==1){
                    countFresh+=1;
                }
            }
        }
        // now i m gonna use those queue elevements one by one and i will be checking if the up down left right elements are good or not 
int[] r = {0 , 1, 0 , -1};
        int[] c = {1, 0 , -1, 0};
        int tm = 0 ; 
        int cnt = 0 ;

        while(!q.isEmpty()){
            

        int row = q.peek().row;
        int col = q.peek().col;
        int t = q.peek().tm;
        q.remove();


            
            for(int i = 0 ; i<4;i++){
            int nrow = row + r[i];
            int ncol = col + c[i];
          
            tm  = Math.max(tm , t);

            // now lets check
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                q.add(new Pair(nrow, ncol, t+1));
                vis[nrow][ncol] = 2;
            cnt++;
                
                
            }
            


            
        }
        


        }
        if(cnt!=countFresh) return -1;
        return tm ;
        




    }
}