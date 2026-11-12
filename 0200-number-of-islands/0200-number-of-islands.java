class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int islands=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col){
        int n=grid.length;
        int m=grid[0].length;
        int[] dr={-1, 1, 0, 0};
        int[] dc={0,0,-1,1};

        grid[row][col]='0';
        

        for(int i=0;i<4;i++){
            int r=row+dr[i];
            int c=col+dc[i];

            if(r>=0 && r<n && c>=0 && c<m && grid[r][c]=='1'){
                dfs(grid, r, c);
            }
        }
        return;
    }
}