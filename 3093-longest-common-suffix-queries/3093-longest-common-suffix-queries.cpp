struct FlatNode {
    int children[26];
    int bestIndex;

    FlatNode(int idx) {
        fill(begin(children), end(children), -1);
        bestIndex = idx;
    }
};

class Solution {
private:
    vector<FlatNode> trie;

    void insert(const string& word, int wordIdx, const vector<string>& wordsContainer) {
        int currIdx = 0;
        int n = word.length();
        
        for (int i = n - 1; i >= 0; --i) {
            int charIdx = word[i] - 'a';
            
            if (trie[currIdx].children[charIdx] == -1) {
                trie[currIdx].children[charIdx] = trie.size();
                trie.push_back(FlatNode(wordIdx));
            }
            
            currIdx = trie[currIdx].children[charIdx];
            
            int bestIdx = trie[currIdx].bestIndex;
            if (n < wordsContainer[bestIdx].length()) {
                trie[currIdx].bestIndex = wordIdx;
            } else if (n == wordsContainer[bestIdx].length() && wordIdx < bestIdx) {
                trie[currIdx].bestIndex = wordIdx;
            }
        }
    }

    int search(const string& query) {
        int currIdx = 0;
        int n = query.length();
        int lastBest = trie[0].bestIndex;
        
        for (int i = n - 1; i >= 0; --i) {
            int charIdx = query[i] - 'a';
            if (trie[currIdx].children[charIdx] == -1) {
                break;
            }
            currIdx = trie[currIdx].children[charIdx];
            lastBest = trie[currIdx].bestIndex;
        }
        return lastBest;
    }

public:
    vector<int> stringIndices(vector<string>& wordsContainer, vector<string>& wordsQuery) {
        // Step 1: Pre-calculate the ultimate fallback string index for the root node
        int defaultIdx = 0;
        for (int i = 1; i < wordsContainer.size(); ++i) {
            if (wordsContainer[i].length() < wordsContainer[defaultIdx].length()) {
                defaultIdx = i;
            }
        }

        // Initialize the trie buffer by reserving space to minimize re-allocations
        trie.clear();
        trie.push_back(FlatNode(defaultIdx));

        // Step 2: Construct the Trie using flat indices
        for (int i = 0; i < wordsContainer.size(); ++i) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        // Step 3: Match the query entries
        vector<int> ans;
        ans.reserve(wordsQuery.size());
        for (const string& query : wordsQuery) {
            ans.push_back(search(query));
        }

        return ans;
    }
};