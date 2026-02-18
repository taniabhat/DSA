struct Node{
    Node* links[26];
    bool flag=false;
    Node(){
        flag = false;
        for(int i = 0; i < 26; i++)
            links[i] = NULL;
    }
    bool containkey(char ch){
        return links[ch-'a']!=NULL;
    }
    void put(char ch, Node* node){
        links[ch-'a']=node;
    }
    Node* get( char ch){
        return links[ch-'a'];
    }
    void setend(){
        flag=true;
    }
    bool isend(){
        return flag;
    }
};
class WordDictionary {
private:
    Node* root;
    bool dfs(string &word, int index, Node* node) {
        if(index == word.length())
            return node->isend();

        char ch = word[index];

        if(ch == '.') {
            // try all possible letters
            for(int i = 0; i < 26; i++) {
                if(node->links[i] != NULL) {
                    if(dfs(word, index + 1, node->links[i]))
                        return true;
                }
            }
            return false;
        }
        else {
            if(!node->containkey(ch))
                return false;
            return dfs(word, index + 1, node->get(ch));
        }
    }
public:
    WordDictionary() {
        root=new Node();
    }
    
    void addWord(string word) {
        Node* node=root;
        for(char ch:word){
            if(!node->containkey(ch)){
                node->put(ch, new Node());
            }
            node=node->get(ch);
        }
        node->setend();
    }
    
    bool search(string word) {
        return dfs(word, 0, root);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */