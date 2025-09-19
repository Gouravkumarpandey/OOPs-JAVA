#include<iostream>
#include<vector>

using namespace std;

bool isAnagram(string s, string t){
    if(s.length() != t.length()) return false;

    vector<int> count(26,0);
    
    for(int i =0;i<s.size(); i++){
        count[s[i] - 'a']++;
        count[t[i] - 'a']--;
    }
    for (int c : count){
        if ( c != 0) return false;
    }
return true;
}
int main(){
    string s = "anagram";
    string t = "nagaram";

    if(isAnagram(s,t)){
        cout<<"True"<<endl;
    }else{
        cout<<"False"<<endl;
    }
    return 0;
}