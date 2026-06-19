#include <bits/stdc++.h>
using namespace std;

class singleton{
    private:
    static singleton* instance;
    singleton(){
        cout<<"The singleton constructor is called\n";
    }

    public:
    static singleton* getinstance(){
        if(instance == nullptr){
            return new singleton();
        }
        return instance;
    }
};

singleton* singleton::instance = nullptr;
int main() {
    singleton* s1 = singleton::getinstance();
    singleton* s2 = singleton::getinstance();

    cout<<(s1 == s2)<<endl;
    
    return 0;
}
