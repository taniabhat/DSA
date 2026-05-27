class Solution {
public:
    int numberOfSpecialChars(string word) {
        int specialcharcnt=0;
        for(char c='a';c<='z';c++){
            char lower=c;
            char upper=toupper(c);
            int loweridx1=-1;
            int upperidx1=-1;

            for(int i=0;i<word.length();i++){
                if(word[i]==lower) loweridx1=i;
                else if(word[i]==upper && upperidx1==-1) upperidx1=i;
            }
            if(loweridx1!=-1 && upperidx1!=-1) specialcharcnt++;
        }
        return specialcharcnt;
    }
};