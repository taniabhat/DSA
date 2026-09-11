class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq=new int[10];

        for(int d: digits){
            freq[d]++;
        }

        List<Integer> res=new ArrayList<>();

        for(int i=100;i<=999;i+=2){
            int h=i/100;
            int t=(i/10)%10;
            int o=i%10;

            int[] temp=freq.clone();

            temp[h]--;
            temp[t]--;
            temp[o]--;

            if(temp[h]>=0 && temp[t]>=0 && temp[o]>=0){
                res.add(i);
            }
        }
        int n=res.size();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=res.get(i);
        }
        return result;
    }
}