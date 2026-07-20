class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int total=m*n;
        k=k%total;
        List<List<Integer>> res=new ArrayList<>();
        for(int r=0;r<m;r++){
            List<Integer> row=new ArrayList<>();
            for(int c=0;c<n;c++){
                int new1D=r*n+c;
                int old1D=(new1D-k%total+total)%total;

                int oldr=old1D/n;
                int oldc=old1D%n;

                row.add(grid[oldr][oldc]);

            }
            res.add(row);
        }
        return res;
    }
}