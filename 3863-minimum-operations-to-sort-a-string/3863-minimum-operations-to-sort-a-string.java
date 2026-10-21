class Solution {
    private int count(char[] arr, int target){
        int cnt=0;
        for(char c:arr){
            if(c==target) cnt++;
        } 
        return cnt;
    }
    private boolean sorted(String s){
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)>s.charAt(i+1)) return false;
        }
        return true;
    }
    public int minOperations(String s) {
        int n=s.length();

        if(sorted(s)) return 0;
        if(s.length()==2) return -1;

        char[] arr=s.toCharArray();
        int minChar=arr[0];
        int maxChar=arr[n-1];
        for(char c:arr){
            minChar=Math.min(minChar, c);
            maxChar=Math.max(maxChar, c);
        }

        if(minChar==arr[0] || maxChar==arr[n-1]) return 1;

        if(minChar==arr[n-1] && maxChar==arr[0] && count(arr,minChar)==1 && count(arr,maxChar)==1) return 3;

        return 2;
        
    }
}