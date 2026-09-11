class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];

        for(int d: digits){
            freq[d]++;
        }

        int cnt=0;

        for(int i=100;i<=999;i+=2){
            int[] temp=freq.clone();

            int a=i/100;        //hundreds
            int b=(i/10)%10;  //tens
            int c=i%10;        //ones

            temp[a]--;
            temp[b]--;
            temp[c]--;

            if(temp[a]>=0 && temp[b]>=0 && temp[c]>=0) cnt++;


        }
        return cnt;
    }
}