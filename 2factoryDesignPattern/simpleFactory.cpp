#include <bits/stdc++.h>
using namespace std;

class burger{
    public:
    virtual void prepare() = 0;
    virtual ~burger() {};
};

class basicBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with basic bun basic steak and ketcup";
    }
};

class standardBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with  bun  steak cheesse slice latice and ketcup";
    }
};

class premiumBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with premium bun premium steak and double cheese slice and latice";
    }
};

class burgerFactory{
    public:
    burger* createBurger(string type){
        if(type == "basic") return new basicBurger();
        else if(type == "standard") return new standardBurger();
        else if(type == "premium") return new premiumBurger();
        else{
            cout<<"InValid Type";
            return NULL;
        }
    }
};



int main() {
    string type = "standard";

    burgerFactory* myburgrtFactory = new burgerFactory();
    burger* burger1 = myburgrtFactory->createBurger(type);
    burger1->prepare();
    return 0;
}
