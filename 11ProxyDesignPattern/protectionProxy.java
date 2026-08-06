interface IDocumentReader{
    void unlockPDF(String filepath,String password);
}

class ReadDocumentReader implements IDocumentReader{
    @Override
    public void unlockPDF(String filepath,String password){
        System.out.println("[real documents] Unlocking PDF at : " + filepath);
        System.out.println("[real documents] Unlocking PDF with Password : " + password);
        System.out.println(" Displaying PDF Content... ");
    }
}

class User {
    public String name;
    public boolean premiumMembership;

    public User(String name,boolean isPremium){
        this.name = name;
        this.premiumMembership = isPremium;
    }
}

class DocumentProxy implements IDocumentReader{
    private ReadDocumentReader realReader;
    private User user;

    public DocumentProxy(User user){
        this.realReader = new ReadDocumentReader();
        this.user = user;
    }

    @Override
    public void unlockPDF(String filePath, String password) {
        if (!user.premiumMembership) {
            System.out.println("[DocumentProxy] Access denied. Only premium members can unlock PDFs.");
            return;
        }
        realReader.unlockPDF(filePath, password);
    }

}



public class protectionProxy {
    public static void main(String[] args) {
        User user1 = new User("vicky", true);
        User user2 = new User("ashish", false);
        // user1.premiumMembership = false;


        System.out.println("Ashish aka Non-premium user tries to Unlock the Pdf... ");
        IDocumentReader docReader = new DocumentProxy(user2);
        docReader.unlockPDF("protected_document.pdf", "secret123");

    
        System.out.println("\nVicky aka Premium user tries to Unlock the Pdf... ");
        docReader = new DocumentProxy(user1);
        docReader.unlockPDF("protected_document.pdf", "secret123");
        
    }

}
