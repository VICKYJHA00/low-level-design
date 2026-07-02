interface Character{
    String getAbility();
}


class Mario implements Character{
    @Override
    public String getAbility(){
        return "mario";
    }
}

abstract class CharacterDecorator implements Character{
    protected Character character;

    public CharacterDecorator(Character c){
        this.character = c;
    }

}


class HeightUp extends CharacterDecorator {

    public HeightUp(Character c){
        super(c);
    }

    public String getAbility(){
        return character.getAbility() + "with height up";
    }

}

class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character c){
        super(c);
    }

    public String getAbility(){
        return character.getAbility() + "with gun power up";
    }
}

class FlyingPowerUp extends CharacterDecorator {

    public FlyingPowerUp(Character c){
        super(c);
    }

    public String  getAbility(){
        return character.getAbility() + "with Flying power up";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Character mario = new Mario() ;
        System.out.println("basic Character : "  + mario.getAbility());

        mario = new HeightUp(mario);
        System.out.println("Character with height up : "  + mario.getAbility());

        mario = new GunPowerUp(mario);
        System.out.println("Character with gun power up : " + mario.getAbility());

        mario = new FlyingPowerUp(mario);
        System.out.println("Character with Flying power up : " + mario.getAbility());
    }
}
