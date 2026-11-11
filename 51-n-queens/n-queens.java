class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int col = 0 ; col<n;col++){
            Arrays.fill(board[col],'.');
        }
        solve(0, board, ans, n);
        return ans;
    }
    public void solve(int row, char[][] board, List<List<String>> ans , int n){
        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int col = 0 ; col<n;col++){
                temp.add(new String(board[col]));
            }
            ans.add(temp);
            return;
        }
        for(int col = 0 ;col<n;col++){
            if(isSafe(row, col ,board, n)){
                board[row][col] = 'Q';
                solve(row+1, board, ans , n);
                board[row][col]='.';
            }
        }
       

    }
    public boolean isSafe(int row, int col , char[][] board, int n){
        // check coloumn wise
        for(int i = row-1;i>=0;i--){
            if(board[i][col]=='Q')return false;

        }

        // check top left
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')return false;
            r--;
            c--;

        }

        // check top right 
        r= row-1;
        c= col+1;
        while(r>=0 && c<n){
            if(board[r][c]=='Q')return false;
            r--;
            c++;
            
        }

        return true;




    }
}