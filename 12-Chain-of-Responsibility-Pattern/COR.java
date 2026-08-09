abstract class MoneyHandler{
    protected MoneyHandler nexthandler;

    public  MoneyHandler(){
        this.nexthandler = null;
    }

    public void setHandler(MoneyHandler handler){
        this.nexthandler = handler;
    }

    public abstract void dispense(int amount);
}

class ThousandHandler extends MoneyHandler{
    private int count;

    public ThousandHandler(int count){
        this.count = count;
    }

    @Override
    public void dispense(int amount){
        int notesNeeded = amount/1000;
        if(count < notesNeeded){
            notesNeeded = count;
            count = 0;
        }else{
            count -= notesNeeded;
        }

        if(notesNeeded > 0){
        System.out.println("Dispensing " + notesNeeded + " x ₹1,000 notes.");
        }

        int remaining = amount - (notesNeeded*1000);

        if(remaining > 0){
          if(nexthandler != null) nexthandler.dispense(remaining);
          else System.out.println("The remaining Amount of" + remaining + "can't be dispense as (insufficient balance in bank) ");
        }
    }
}

class fiveHundredHandler extends MoneyHandler{
    private int count;

    public fiveHundredHandler(int count){
        this.count = count;
    }

    @Override
    public void dispense(int amount){
        int notesNeeded = amount/500;
        if(count < notesNeeded){
            notesNeeded = count;
            count = 0;
        }else {
            count -= notesNeeded;
        }
        if(notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + " x ₹500 notes.");
        }
        int remaining = amount - (notesNeeded*500);
        if(remaining > 0){
            if(nexthandler != null) nexthandler.dispense(remaining);
            else System.out.println("The remaining Amount of" + remaining + "can't be dispense as insufficient fund");
        }
    }
}

class twoHunderHandler extends MoneyHandler{
    private int count;

    twoHunderHandler(int count){
        this.count = count;
    }


    @Override
    public void dispense(int amount){
        int notesNeeded = amount/200;
        if(notesNeeded > count){
            notesNeeded = count;
            count = 0;
        }else{
            count -= notesNeeded;
        }

        if(notesNeeded>0){
        System.out.println("Dispensing " + notesNeeded + " x ₹200 notes.");
        }

        int remaining = amount - (notesNeeded*200);
        if(remaining>0){
            if(nexthandler != null) nexthandler.dispense(remaining);
            else System.out.println("The remaining Amount of" + remaining + "can't be dispense as insufficient fund");
        }
    }
}

class HundrenHandler extends MoneyHandler{
    private int count = 0;

    public HundrenHandler(int count){
        this.count = count;
    }

    @Override
    public void dispense(int amount){
        int notesNeeded = amount/100;
        if(notesNeeded > count){
            notesNeeded = count;
            count = 0;
        }else{
            count -= notesNeeded;
        }

        if(notesNeeded>0){
        System.out.println("Dispensing " + notesNeeded + " x ₹100 notes.");
        }

        int remaining = amount - (notesNeeded*100);
        if(remaining>0){
            if(nexthandler != null) nexthandler.dispense(remaining);
            else System.out.println("The remaining Amount of" + remaining + "can't be dispense as insufficient fund");
        }
    }
    
}

public class COR{
    public static void main(String[] args){
        MoneyHandler Thousand = new ThousandHandler(5);
        MoneyHandler fiveHundred = new fiveHundredHandler(4);
        MoneyHandler twoHundred = new twoHunderHandler(3);
        MoneyHandler Hundred = new HundrenHandler(2);

        Thousand.setHandler(fiveHundred);
        fiveHundred.setHandler(twoHundred);
        twoHundred.setHandler(Hundred);

        int amountToWithdraw = 4700;
        System.out.println("\nDispensing amount: ₹" + amountToWithdraw);
        Thousand.dispense(amountToWithdraw);
    }
}