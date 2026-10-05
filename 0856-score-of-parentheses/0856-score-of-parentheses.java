class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(0);
            }else{
                int innerScore=st.pop();
                int addedScore=0;

                if(innerScore==0) addedScore=1;
                else addedScore=2*innerScore;

                int currScore=st.pop();
                st.push(currScore+addedScore);
            }
        }
        return st.pop();
    }
}