class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);

        
    }
    public boolean solve(char[][] grid){
        for(int i = 0 ; i<9;i++){
            for(int j = 0 ; j<9;j++){
                if(grid[i][j]=='.'){

             
                for(int d=1;d<=9;d++){
                    if(isValid(grid, i , j , d)){
                        grid[i][j]=(char)(d + '0');
                        if(solve(grid)) return true;
                        grid[i][j]='.';
                    }

                }
                return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] grid , int row , int col , int d){
        for(int i = 0 ; i<9;i++){
            if(grid[row][i]==(char)(d + '0'))return false;
            if(grid[i][col]==(char)(d + '0'))return false;

        }
        int start_i = row/3*3;
        int start_j = col/3*3;
        for(int i = 0;i<3;i++){
            for(int j = 0 ;j<3;j++){

           
            if(grid[start_i+i][start_j+j]==(char)(d + '0')){
                return false;}
            
        }
        }
        return true;
     }
}