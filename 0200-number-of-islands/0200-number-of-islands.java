class Solution {
    private void bfs(char[][] grid, int row, int col){
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col]='0';

        int[] dr={-1, 1, 0, 0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n 
                && nc>=0 && nc<m &&
                 grid[nr][nc]=='1'){
                    grid[nr][nc]='0';
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }
}