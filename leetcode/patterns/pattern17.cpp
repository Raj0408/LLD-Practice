#include <bits/stdc++.h>

using namespace std;

int main(){
    int n = 0;
    cin >> n;
    for(int i = 1;i<n+1;i++){
        for(int j  = 0;j<n-i;j++){
            cout << " ";
        }
        int mid = (2 * i - 1) / 2;
        int total = (2 * i -1);
        char a = 'A';
        for (int k = 0;k<total;k++){
            cout<<a;
            if(k < mid){
                a++;
            }else{ 
                a--;
            }
        }    
        cout<<"\n";
    }
}