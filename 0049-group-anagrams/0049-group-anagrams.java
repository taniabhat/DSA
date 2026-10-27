class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramgrp=new HashMap<>();

        for(String str: strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);

            String sortedKeys=new String(ch);

            if(!anagramgrp.containsKey(sortedKeys)) anagramgrp.put(sortedKeys, new ArrayList<>());

            anagramgrp.get(sortedKeys).add(str);
        }
        return new ArrayList<>(anagramgrp.values());
    }
}