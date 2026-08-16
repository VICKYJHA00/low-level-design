
interface engine{
    void start();
}

class petrolEngine implements engine{
    @Override
    public void start(){
        System.out.println("Pertol engine is started...");
    }
}

class diselEngine implements engine{

    public void start(){
        System.out.println("Disel engine is started...");
    }
}

class electricEngine implements engine{

    public void start(){
        System.out.println("Electric engine is started...");
    }
}

abstract class car{
    protected engine e;
    public car(engine e){
        this.e = e;
    }

    public abstract void drive();

}

class sedan extends car{

    public  sedan(engine e){
        super(e);
    }

    @Override
    public void drive(){
        e.start();
        System.out.println("Driving sedan on highway\n");
    }
}

class suv extends car{
    suv(engine e){
        super(e);
    }

    public void drive(){
        e.start();
        System.out.println("Driving SUV on the moutain\n");
    }
}



public class Bridge {
    public static void main(String[] args){
        engine pEngine = new petrolEngine();
        engine dEngine = new diselEngine();
        engine engine = new electricEngine();

        car BMW1 = new suv(pEngine);
        car BMW2 = new sedan(engine);
        car BMW3 = new suv(dEngine);

        BMW1.drive();
        BMW2.drive();
        BMW3.drive();
    }    
}
