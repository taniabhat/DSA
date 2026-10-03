class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int maxLen=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch==')'){
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    int currLen=i-st.peek();
                    maxLen=Math.max(currLen, maxLen);
                }
            }else{
                st.push(i);
            }
        }
        return maxLen;
    }
}