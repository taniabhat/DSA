class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0]?b[1]-a[1] : a[0]-b[0]);

        int cnt=0;
        int maxend=Integer.MIN_VALUE;
        for(int[] i:intervals){
            if(i[1]>maxend){
                cnt++;
                maxend=i[1];
            }
        }
        return cnt;
    }
}