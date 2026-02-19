class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        for(int i=0;i<prerequisites.size();i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj[b].push_back(a);
        }

        vector<int> indeg(numCourses);
        for(int i=0;i<numCourses;i++){
            for(auto it: adj[i]) indeg[it]++;
        }

        queue<int> q;
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.push(i);
        }

        vector<int> topo;
        while(!q.empty()){
            int node =q.front();
            q.pop();
            topo.push_back(node);

            for(auto it: adj[node]){
                indeg[it]--;
                if(indeg[it]==0) q.push(it);
            }
        }

        if(topo.size()==numCourses) return topo;
        return {};
    }
};