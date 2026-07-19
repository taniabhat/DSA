class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        int n=intervals.length;
        int idx=0;
        while(idx<n && intervals[idx][1]< newInterval[0]){
            res.add(intervals[idx]);
            idx+=1;
        }
         while(idx<n && intervals[idx][0]<= newInterval[1]){
            newInterval[0]=Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[idx][1]);
            idx+=1;
         }
         res.add(newInterval);
         while(idx<n){
            res.add(intervals[idx]);
            idx+=1;
         }
         return res.toArray(new int[res.size()][]);
    }
}