#include<iostream>
using namespace std;

int hcf(int a, int b){
    int result=1;
for(int i=1; i<=a && i<=b;i++){
   if(a%i==0 && b%i==0){
    result = i;
   } 
}
return result;
}
int main(){
    int a, b;
    cout<< "Enter two numbers: ";
    cin >> a >> b;
    cout << "HCF = "<<hcf(a,b);
    return 0;
}