interface Remote{
    String getData();
}

class realRemote implements Remote{
    public realRemote(){
        System.out.println("[realRemote] Connecting to the remote server...");
    }

    @Override
    public String getData(){
        System.out.println("[realRemote] Fetching data from the remote server...");
        return "[realRemote] Data from the remote server";
    }
}

class RemoteProxy implements Remote{
    private realRemote realRemote;
    
    public RemoteProxy(){
        this.realRemote = new realRemote();
    }

    @Override
    public String getData(){
        System.out.println("[RemoteProxy] Logging access to remote server...");
        return realRemote.getData();
    }
}

public class remoteProxy {
    public static void main(String[] args){
        Remote remote = new RemoteProxy();
        remote.getData();
    }
}
