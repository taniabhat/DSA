class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        //int idx=1;
        int n=intervals.length;
        int[] currinterval=intervals[0];
        res.add(currinterval);

        for(int[] i:intervals){
            int currend=currinterval[1];
            int nextstart=i[0];
            int nextend=i[1];
            //overlap
            if(nextstart<=currend){
                currinterval[1]=Math.max(currend, nextend);
            }else{
                currinterval=i;
                res.add(currinterval);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}