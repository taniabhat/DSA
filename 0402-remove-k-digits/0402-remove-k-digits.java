class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(k>0 && ans.length()>0 && ans.charAt(ans.length()-1)>ch){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            ans.append(ch);
        }
        //Edge cases
        //removing remaining k digits from the end
        while(k>0 && ans.length()>0){
                ans.deleteCharAt(ans.length()-1);
                k--;
        }
        //removing trailing zeroes
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        //checking if ans is 0
        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }
}