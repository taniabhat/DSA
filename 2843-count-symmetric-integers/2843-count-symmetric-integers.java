class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;

        for(int i=low;i<=high;i++){
            String sdig=String.valueOf(i);

            if(sdig.length()%2==0){
                int mid=sdig.length()/2;
                int firstSum=0;
                int secSum=0;

                for(int j=0;j<mid;j++) firstSum+=sdig.charAt(j)-'0';
                for(int j=mid;j<sdig.length();j++) secSum+=sdig.charAt(j)-'0';

                if(firstSum==secSum) cnt++;
            }
        }
        return cnt;
    }
}