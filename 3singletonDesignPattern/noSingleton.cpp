#include <bits/stdc++.h>
using namespace std;

class singleton{
    public:
    singleton(){
        cout<<"Singleton constructor called , new object created\n";
    }
};

int main() {
    singleton* s1 = new singleton();
    singleton* s2 = new singleton();

    cout<<(s1 == s2)<<endl;

    return 0;
}
