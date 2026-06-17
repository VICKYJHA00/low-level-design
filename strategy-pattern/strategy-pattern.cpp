#include<iostream>
using namespace std;

// --- Strategy Interface for Walk ---

class WalkableRobot {
    public:
     virtual void walk() = 0;
     virtual ~WalkableRobot(){}
};

// --- Concrete Strategies for walk ---
class NormalWalk : public WalkableRobot {
    public:
        void walk() override {
            cout<<"Can Walk\n";
        }
};


class NoWalk : public WalkableRobot{
    public: 
    void walk() override {
        cout<<"Can't walk\n";
    }
};

// --- Strategy Interface for Talk ---

class TalkAble{
    public:
        virtual void talk() = 0;
        virtual ~TalkAble(){}
};

// --- Concrete Strategies for Talk ---

class NormalTalk : public TalkAble{
    void talk() override {
        cout<<"Can talk\n";
    }
};

class NoTalk : public TalkAble{
    void talk() override{
        cout<<"Can't talk\n";
    }
};

// --- Strategy Interface for Fly ---

class FlyRobot{
    public:
        virtual  void fly() = 0;
        virtual ~FlyRobot(){}
};

// --- Concrete Strategies for Fly ---

class NormalFly : public FlyRobot{
    void fly() override{
        cout<<"Can fly\n";
    }
};

class NoFly : public FlyRobot{
    void fly() override {
        cout<<"Cannot Fly\n";
    }
};

// --- Robot Base Class ---
class Robot{
    protected:
        WalkableRobot* walkBehaviour;
        TalkAble* talkBehaviour;
        FlyRobot* flyBehaviour;
    public:
        Robot(WalkableRobot* w, TalkAble* t, FlyRobot* f ){
            this->walkBehaviour = w;
            this->talkBehaviour = t;
            this->flyBehaviour = f;
        }

        void walk(){
            walkBehaviour->walk();
        }

        void talk(){
            talkBehaviour->talk();
        }

        void fly(){
            flyBehaviour->fly();
        }

        virtual void projection() = 0;
};

// --- Concrete Robot Types ---

class campanionRobot : public Robot{

    public :

    campanionRobot(WalkableRobot* w, TalkAble* t , FlyRobot* f) : Robot(w,t,f) {}

    void projection() override{
        cout<<"Display ComanionRobot feature are : .....\n";
    }
};

class workerRobot : public Robot{

    public:

    workerRobot(WalkableRobot* w, TalkAble* t, FlyRobot* f) : Robot(w,t,f) {}

    void projection() override{
        cout<<"The Woker Robot stats Are : ....\n.";
    }

};


// --- Main Function ---
int main(){

    campanionRobot *robot1 = new campanionRobot ( new NormalWalk, new NormalTalk, new NormalFly);
    cout<<"THE campanion Robot can :\n";
    robot1->walk();
    robot1->talk();
    robot1->fly();
    robot1->projection();


    workerRobot* robot2 = new workerRobot(new NormalWalk, new NoTalk,new NoFly );
    cout<<"The worker Robot can :\n";
    robot2->walk();
    robot2->talk();
    robot2->fly();
    robot2->projection();

    return 0;


}