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

class basicWheatBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with basic bun basic steak and ketcup and wheat";
    }
};

class standardWheatBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with  bun  steak cheesse slice latice and ketcup and wheat";
    }
};

class premiumWheatBurger : public burger{
    public:
    void prepare() override{
        cout<<"preparing burger with premium bun premium steak and double cheese slice and latice and wheat";
    }
};


class garlicBread{
    public:
    virtual void prepare() = 0;
    virtual ~garlicBread(){};
};

class basicGarlicBread : public garlicBread{
    public:
    void prepare() override{
        cout<<"create basic garlic bread";
    }
};

class whearGarlicBread : public garlicBread{
    public:
    void prepare() override{
        cout<<"preapare wheat garlic bread";
    }
};


class burgerFactory{    
    public:
    virtual burger* createBurger(string type) = 0;
    virtual garlicBread* createGarlic(string type) = 0;
    
    virtual ~burgerFactory(){};

};

class singhBurger: public burgerFactory{
    public:
    burger* createBurger(string type) override{
        if(type == "basic") return new basicBurger();
        else if(type == "standard") return new standardBurger();
        else if(type == "premium") return new premiumBurger();
        else{
            cout<<"invalid option";
            return nullptr;
        }
    }

    garlicBread* createGarlic(string type){
        if(type == "basic") return new basicGarlicBread();
    }
};

class burgerKing : public burgerFactory{
    public:
    burger* createBurger(string type) override{
        if(type == "basic") return  new basicWheatBurger();
        else if(type == "standard") return new standardWheatBurger();
        else if(type == "premium") return new premiumWheatBurger();
        else{
            cout<<"invalid type";
            return nullptr;
        }
    }

    garlicBread* createGarlic(string type){
        if(type == "basic"){
            return new whearGarlicBread();
        }else {
            cout<<"Invalid option";
            return nullptr;
        }
    }
};



int main() {
    string type = "standard";
    string type1 = "basic";
    burgerFactory* myburger = new burgerKing();
    burger* burger1 = myburger->createBurger(type);
    garlicBread* bread1 = myburger->createGarlic(type1);

    burger1->prepare();
    cout<<endl;
    bread1->prepare();
    return 0;
}


// there is an error of the type i can do two thing either i will create type for everybread like standdard and premium or just take the input fo
// for the garlic bread individual and the second one is good