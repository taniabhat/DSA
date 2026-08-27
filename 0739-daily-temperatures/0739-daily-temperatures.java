class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Arrays.fill(ans,0);
        Stack<Integer> st=new Stack<>();
     
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]> temperatures[st.peek()]){
                int popIdx=st.pop();
                ans[popIdx]=i-popIdx;

            }
            st.push(i);
        }

        return ans;
    }
}