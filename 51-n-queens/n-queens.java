class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int col = 0 ; col<n;col++){
            Arrays.fill(board[col],'.');

        }
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[n*2];
        boolean[] antiDiag = new boolean[n*2];
        solve(0, board, ans , n, col , diag, antiDiag);
        return ans;
      }
      public void solve(int row, char[][] board, List<List<String>> ans, int n, boolean[] col, boolean[] diag, boolean[] antiDiag){
        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int c = 0 ;c<n;c++){
                temp.add(new String(board[c]));
            }
            ans.add(temp);
            return;
        }
        for(int c = 0 ;c<n;c++){
            if(col[c] || diag[row+c] || antiDiag[row-c+n])continue;

            // put the col , diag , antiDiag
            col[c]= true;
            diag[row+c] = true;
            antiDiag[row-c+n]= true;

            board[row][c] = 'Q';
            solve(row+1, board, ans, n , col , diag, antiDiag);
            board[row][c] = '.';
            col[c] = false;
            diag[row+c] = false;
            antiDiag[row-c+n] = false;


        
            
        }
      }
}