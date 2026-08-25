class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int maxA=0;
        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int h=heights[st.pop()];
                int w=st.isEmpty()?i:i-st.peek()-1;
                maxA=Math.max(maxA, h*w);
            }
            st.push(i);
        }
        return maxA;
   }
}