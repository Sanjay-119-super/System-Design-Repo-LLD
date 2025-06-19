// Abstract Decorator
abstract class Decorator implements ICharacter {
    protected ICharacter character; // Wrapped component

    public Decorator(ICharacter character) {
        this.character = character;
    }

    public String getAbilities() {
        return character.getAbilities();
    }
}

class HeightUpDecorator extends Decorator{
    public HeightUpDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + " high up ";
    }
}

class FlyingDecorator extends Decorator{
    public FlyingDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + " Flying";
    }
}

public class Main{
    public static void main(String[] args) {
        ICharacter mario = new Mario();
        mario = new HeightUpDecorator(mario);
        mario=new FlyingDecorator(mario);
        String abilities = mario.getAbilities();
        System.out.println(abilities + " ");

    }
}