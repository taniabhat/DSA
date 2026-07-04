class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] r : roads){
            graph.get(r[0]).add(new int[]{r[1],r[2]});
            graph.get(r[1]).add(new int[]{r[0],r[2]});
        }

        int minscore=Integer.MAX_VALUE;
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();

        q.add(1);
        vis[1]=true;

        while(!q.isEmpty()){
            int u=q.poll();
            for(int[] edge:graph.get(u)){
                int v=edge[0];
                int w=edge[1];

                minscore=Math.min(minscore, w);

                if(!vis[v]){
                    vis[v]=true;
                    q.add(v);
                }
            }
        }
        return minscore;
    }
}