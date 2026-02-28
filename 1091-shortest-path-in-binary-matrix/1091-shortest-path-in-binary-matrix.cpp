class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n=grid.size();

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1; 
        vector<pair<int,int>> dirs={
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},           {0,1},
            {1,-1},   {1,0},  {1,1}
        };

        queue<pair<int,int>> q;
        q.push({0,0});
        grid[0][0]=1;
        int pathlen=1;
        while(!q.empty()){
            int size=q.size();
            while(size--){
                auto [r,c]= q.front();
                q.pop();

                if(r == n-1 && c == n-1)
                    return pathlen;

                for(auto d:dirs){
                    int nr=r+d.first;
                    int nc=c+d.second;

                    if(nc>=0 && nr>=0 && nc<n && nr<n && grid[nr][nc]==0){
                        q.push({nr,nc});
                        grid[nr][nc]=1;
                    }
                }  
            }
            pathlen++;
        }
        return -1;
    }
};