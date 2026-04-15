class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    static boolean solve(char[][] board){
        for(int row = 0 ;row<9;row++){
            for(int col = 0 ; col<9; col++){
                if(board[row][col]=='.'){
                    for(char num = '1' ; num<='9';num++){
                        if(isSafe(board, row, col , num)){
                            board[row][col] = num ; 
                            if(solve(board))return true;
                            board[row][col] ='.';
                        }
                    }
                    return false;     // here we could not find the answer
                    
                }
                  
              
            }
        }
        return true; // solved
    }
    static boolean isSafe(char[][] board , int row , int col , char num){

        // row check 
        for(int i = 0 ; i<9 ;i++){
            if(board[row][i]== num){
                return false;
            }

        }
        // col check 
        for(int i = 0 ; i<9 ;i++){
            if(board[i][col]== num){
                return false;
            }

        }


        // the box check 
        int startRow = (row /3 )*3;
        int startCol = (col /3)*3;
        for(int i = startRow ; i <startRow +3;i++){
            for(int j = startCol ; j<startCol +3 ; j++){
                if(board[i][j]==num)return false;
            }
        }
 
        return true ; 

    }
}