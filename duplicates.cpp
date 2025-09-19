#include<iostream>
#include<unordered_set>
#include<vector>
using namespace std;

bool hasduplicate(vector<int> & num){
    unordered_set<int>element;
    for(int num : num){
        if(element.count(num)){
            return true;
        
        }
        element.insert(num);

    }
    return false;
}

int main(){
    vector<int>num={1,2,3,4,5,6,7,8};
    if(hasduplicate(num)){
        cout<<"Duplicates found"<<endl;
    }
    else{
        cout<<"No duplicates found"<<endl;
    }
    return 0;
 }