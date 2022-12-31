package Graph;

import java.util.LinkedList;
import java.util.List;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
public class SuroundedRegions {
    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
        // Step 1). construct the list of border cells
        for (int r = 0; r < this.ROWS; ++r) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, this.COLS - 1));
        }
        for (int c = 0; c < this.COLS; ++c) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(this.ROWS - 1, c));
        }

        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            this.DFS(board, pair.first, pair.second);
        }

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
    }

    protected void DFS(char[][] board, int row, int col) {
        if (board[row][col] != 'O')
            return;

        board[row][col] = 'E';
        if (col < this.COLS - 1)
            this.DFS(board, row, col + 1);
        if (row < this.ROWS - 1)
            this.DFS(board, row + 1, col);
        if (col > 0)
            this.DFS(board, row, col - 1);
        if (row > 0)
            this.DFS(board, row - 1, col);
    }
}
// Another solution less time

class Solution {
    private void dfs(int row,int col,char[][] board,int[][] vis,int delrow[],int delcol[]){
        int m=board.length;
        int n=board[0].length;
        vis[row][col]=1;
        //neighbours
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            //validation
            if(nrow>=0  && ncol>=0 && nrow<m && ncol<n && board[nrow][ncol]=='O' && vis[nrow][ncol]==0 )
                dfs(nrow,ncol,board,vis,delrow,delcol);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis = new int[m][n];
        int delrow[]={-1,1,0,0};
        int delcol[]={0,0,-1,1};

        //l&r
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && vis[i][0]==0)
                dfs(i,0,board,vis,delrow,delcol);

            if(board[i][n-1]=='O' && vis[i][n-1]==0)
                dfs(i,n-1,board,vis,delrow,delcol);

        }

        // u&d
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && vis[0][j]==0)
                dfs(0,j,board,vis,delrow,delcol);

            if(board[m-1][j]=='O' && vis[m-1][j]==0)
                dfs(m-1,j,board,vis,delrow,delcol);

        }

        //filling remaining 0's

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                    board[i][j]='X';
            }
        }

    }
}


