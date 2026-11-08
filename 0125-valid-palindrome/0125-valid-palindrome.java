class Solution {
    public boolean isPalindrome(String s) {
        String str=s.toLowerCase().replaceAll("[^a-z0-9]", "");
    
        String rev=new StringBuilder(str).reverse().toString();

        return str.equals(rev);
    }
}