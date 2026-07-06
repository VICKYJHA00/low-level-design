

// command interface
interface Command{
    
    void execute();
    void undo();

}

// receivers class

class light{
    public void on(){
        System.out.println("light is on");;
    }
    public void off(){
        System.out.println("light is off");
    }
}

class fan{

    public void on(){
        System.out.println("fan is on");;
    }

    public void off(){
        System.out.println("fan is off");
    }

}

class lightCommand implements Command{

    private light l;

    public lightCommand(light l){
        this.l = l;
    }
    
    public void execute(){
        l.on();
    }

    public void undo(){
        l.off();
    }

}



