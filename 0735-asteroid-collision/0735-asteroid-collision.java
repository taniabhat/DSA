class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;

        for(int i : asteroids){
            boolean survive=true;
            while(survive && i<0 && !st.isEmpty() && st.peek()>0){
                int top=st.peek();
                if(top < -i) st.pop();
                else if(top == -i) {
                    st.pop();
                    survive=false;
                }
                else survive=false;
            }
            if(survive) st.push(i);
        }
        int[] ans=new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i]=st.get(i);
        }
        
        return ans;
        
    }
}