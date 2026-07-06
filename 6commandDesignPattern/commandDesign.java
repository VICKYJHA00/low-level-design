

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

class fanCommand implements Command{
    private fan f;

    public fanCommand(fan f){
        this.f = f;
    }

    public void execute(){
        f.on();
    }

    public void undo(){
        f.off();
    }
}

class remoteContoller{
    private static final int newButton = 4;
    private Command[] buttons;
    private boolean[] buttonpressed;

    public remoteContoller(){
        buttons = new Command[newButton];
        buttonpressed = new boolean[newButton];
        for(int i = 0;i<newButton;i++){
            buttons[i] = null;
            buttonpressed[i] = false;
        }
    }

    public void setCommand(int idx,Command cmd){
        if(idx>= 0 && idx<newButton){
            buttons[idx] = cmd;
            buttonpressed[idx] = false;
        }
    }

    public void pressButton(int idx){
        if(idx>=0 && idx < newButton && buttons[idx] != null){
            if(!buttonpressed[idx]){
                buttons[idx].execute();
            }else{
                buttons[idx].undo();
            }
            buttonpressed[idx] = !buttonpressed[idx];
        }else{
            System.out.println("button not set");
        }
    }

}


//commandDesign.java
public class commandDesign{
    public static void main(String[] args){
        light livingLight = new light();
        fan ceilingFan = new fan();

        remoteContoller remote = new remoteContoller();

        remote.setCommand(0,new lightCommand(livingLight));
        remote.setCommand(1, new fanCommand(ceilingFan));

        System.out.println("-- toggling light button");
        remote.pressButton(0);
        remote.pressButton(0);

        System.out.println("-- toggling of fan button --");
        remote.pressButton(1);
        remote.pressButton(1);

        System.out.println("pressed the unassigned button");
        remote.pressButton(2);
    
    }
}



