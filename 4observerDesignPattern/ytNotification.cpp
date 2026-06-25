#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;


class Isubscriber{
public:
    virtual void update() = 0;
    virtual ~Isubscriber() {} 

};

class Ichannel{
public:
    virtual void subsribe(Isubscriber* subsriber) = 0;
    virtual void unsubsribe(Isubscriber* subsriber) = 0;
    virtual void notifySubsriber() = 0;
    virtual ~Ichannel() {}
};

class Channel :  public Ichannel{
private:

    vector<Isubscriber*> subsribers;
    string name;
    string latestVideo;

public:

    Channel(const string& name){
        this->name = name;
    }

    void subsribe(Isubscriber* subscriber) override {
        if(find(subsribers.begin(), subsribers.end(), subscriber) == subsribers.end()){
            subsribers.push_back(subscriber);
        }
    }

    void unsubsribe(Isubscriber* subscriber) override{
        auto it = find(subsribers.begin(),subsribers.end(), subscriber);
        if(it != subsribers.end()) subsribers.erase(it);
    }

    void notifySubsriber() override{
        for(Isubscriber* sub : subsribers){
            sub->update();
        }
    }

    void uploadvideos(const string& title){
        latestVideo = title;
        cout<<"\n[" << name << "uploaded \ " " " << title << "\"]\n";
        notifySubsriber();
    }

    string getVideoData(){
        return "\n checkout for new videos" + latestVideo + "\n";
    }
    
};

class Subscriber : public Isubscriber{
    private :
      string name;
      Channel* channel;
    public:
        Subscriber(const string& name, Channel* channel){
            this->name = name;
            this->channel = channel;
        }

        void update() override{
            cout<<" Hey " << name << "," << this->channel->getVideoData() ; 
        }
};

int main(){
    Channel* channel  = new Channel("vicky");
    
    Subscriber* s1 =  new Subscriber("prem", channel);
    Subscriber* s2 =  new Subscriber("ashish", channel);

    channel->subsribe(s1);
    channel->subsribe(s2);

    channel->uploadvideos("observer design pattern");

    channel->unsubsribe(s2);

    channel->uploadvideos("hello guys");

    return 0;
}

