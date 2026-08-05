class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] i: invocations){
            int from=i[0];
            int to=i[1];
            graph[from].add(to);
        }

        boolean[] issus=new boolean[n];
        dfs(k,graph, issus);

        boolean canremove=true;;
        for(int[] i:invocations){
            int from=i[0];
            int to=i[1];

            if(!issus[from] &&issus[to]){
                canremove=false;
                break;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!canremove || !issus[i]){
                res.add(i);
            }
        }
        return res;
    }
    private void dfs(int node, List<Integer>[] graph, boolean[] issus){
        issus[node]=true;
        for(int neigh:graph[node]){
            if(!issus[neigh] ) dfs(neigh, graph, issus);
        }
    }
}