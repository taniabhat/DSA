class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=0;
        for(int i=citations.length-1;i>=0;i--){
            int x=citations.length-i;
            if(citations[i]>=x){
                h=x;
            }else break;
        }
        return h;
    }
}