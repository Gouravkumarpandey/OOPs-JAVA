#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> frequencyMap;

        for (string& str : strs) {
            string key = getFrequencyString(str);  // build frequency signature
            frequencyMap[key].push_back(str);
        }

        vector<vector<string>> result;
        for (auto& entry : frequencyMap) {
            result.push_back(entry.second);
        }
        return result;
    }

private:
    // helper function: build a frequency signature string
    string getFrequencyString(const string& str) {
        vector<int> count(26, 0);  // assuming lowercase a-z
        for (char c : str) {
            count[c - 'a']++;
        }

        string key;
        for (int num : count) {
            key += to_string(num) + "#";  // separator to avoid merging numbers
        }
        return key;
    }
};

int main() {
    Solution sol;
    vector<string> strs = {"eat","tea","tan","ate","nat","bat"};

    vector<vector<string>> result = sol.groupAnagrams(strs);

    for (auto& group : result) {
        cout << "[ ";
        for (auto& word : group) {
            cout << word << " ";
        }
        cout << "]" << endl;
    }

    return 0;
}
