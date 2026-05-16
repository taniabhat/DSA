class Solution {
public:
    bool ispallindrome(const string& s, int left, int right){
        while(left<right){
            if(s[left]!=s[right]) return false;
            left++;
            right--;
        }
        return true;
    }
    void backtrack(const string& s,int start, vector<string>& path,vector<vector<string>>& result){
        if(start==s.length()){
            result.push_back(path);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(ispallindrome(s, start ,i )){
                path.push_back(s.substr(start, i-start+1));
                backtrack(s,i+1,path,result);
                path.pop_back();
            }
        }
        
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> path;
        backtrack(s,0,path, result);
        return result;
    }
};