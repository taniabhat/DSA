class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited, isConnected);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int node, boolean[] visited, int[][] isConnected){
        visited[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==false && isConnected[node][i]==1){
                dfs(i, visited, isConnected);
            }
        }
        return;
    }
}