#include <iostream>
#include<mutex>
using namespace std;

class singleton{
    private:
    static singleton* instance;
    static mutex mtx;
    singleton(){
        cout<<"The singleton constructor is called\n";
    }

    public:
    static singleton* getinstance(){
        if(instance == nullptr){ 
            lock_guard<mutex> lock(mtx);
            if(instance == nullptr){
                instance =  new singleton();
            }
        }   
        return instance;
    }
};

singleton* singleton::instance = nullptr;
mutex singleton :: mtx;
int main() {
    singleton* s1 = singleton::getinstance();
    singleton* s2 = singleton::getinstance();

    cout<<(s1 == s2)<<endl;

     

    return 0;
}



// so by adding this it will be safe from the multithread like when we call the multithred it can create different instance so this will lock that