class Solution {
    public long[] sumOfThree(long num) {
        ArrayList<Long> arr=new ArrayList<>();
        if(num%3!=0){
            return new long[]{};
        }
        long x=num/3;
        if(((x-1)+x+(x+1))==num){
            arr.add(x-1);
            arr.add(x);
            arr.add(x+1);
        }
        else x++;
        long[] res=new long[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}