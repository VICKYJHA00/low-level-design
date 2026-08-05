interface IImage{
    void display();
}

class RealImage implements IImage{

    private String filename;

    public RealImage(String file){
        this.filename = file;
        System.out.println("[realImage] loading from the disk ...  "  + filename);
    }

    public void display(){
        System.out.println("real image is display from" + filename );
    }

}

class ProxyImage implements IImage{
    private RealImage realimage;
    private String filename;

    public ProxyImage(String file){
        this.filename = file;
        this.realimage = null;
    }

    public void display(){
        if(realimage == null){
            realimage = new RealImage(filename);
        }
        realimage.display();
    }
}

public class virtualProxy {
    public static void main(String[] args){
        IImage image1 = new ProxyImage("sample.jpg");
        image1.display();
    }
}
