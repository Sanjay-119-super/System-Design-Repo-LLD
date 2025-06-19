// ✅ Interface for all characters
interface ICharacter {
    /**
     * @return character ke abilities return karega
     */
    String getAbilities();
}

// ✅ Concrete Character
class Mario implements ICharacter {
    /**
     * Mario ka base ability return karta hai
     * @return Basic Mario ability string
     */
    @Override
    public String getAbilities() {
        return "Basic Mario Bhai"; // 👈 Custom message for base Mario
    }
}

// ✅ Abstract Decorator
abstract class Decorator implements ICharacter {
    protected ICharacter character; // 👇 Ye actual character jisko decorate karna hai

    /**
     * @param character - jisko decorate (extend) karna hai
     */
    public Decorator(ICharacter character) {
        this.character = character;
    }

    @Override
    public String getAbilities() {
        return character.getAbilities(); // 👇 Base abilities return karo
    }
}

// ✅ Concrete Decorator: Height Up Feature
class HeightUpDecorator extends Decorator {
    /**
     * @param character - jis character ko height ability dena hai
     */
    public HeightUpDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + " + Height Up";
    }
}

// ✅ Concrete Decorator: Flying Feature
class FlyingDecorator extends Decorator {
    /**
     * @param character - jis character ko flying ability dena hai
     */
    public FlyingDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + " + Flying";
    }
}

// ✅ Main class to test decorator pattern
public class Main {
    public static void main(String[] args) {
        // Step 1: Basic character
        ICharacter mario = new Mario();

        // Step 2: Add Height Up feature
        mario = new HeightUpDecorator(mario);

        // Step 3: Add Flying feature
        mario = new FlyingDecorator(mario);

        // Final output of abilities
        String abilities = mario.getAbilities();
        System.out.println("Mario Abilities: " + abilities);
    }
}

/*
🧠 Thought Process (Hinglish):
--------------------------------------
- Decorator Pattern ka use hota hai jab hume kisi object ke behavior ko **runtime par extend** karna hota hai
- Yahan `Mario` base character hai
- `HeightUpDecorator` aur `FlyingDecorator` usko naye abilities de rahe hai without changing original class
- Ye pattern open-closed principle follow karta hai (open for extension, closed for modification)

🎯 Interview Line:
"Decorator Pattern allow karta hai kisi object ke functionality ko dynamically add karne ke liye bina original code ko modify kiye."

✅ Real-World Examples:
- Java I/O Streams (BufferedInputStream wrapping FileInputStream)
- Pizza topping add karna (base pizza + cheese + olives)
- Game character power-ups (jaise humne yahan kiya)
*/
