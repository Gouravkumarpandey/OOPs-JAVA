#include<iostream>
#include<vector>
#include<unordered_map>
#include<string>

using namespace std;

class Solution {

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
}


