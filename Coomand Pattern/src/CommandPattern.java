/**
 * Command Interface - Sab commands (Light, Fan etc.) is interface ko implement karenge.
 */
 interface ICommand {

    /**
     * Kaam start karne ke liye method (e.g. Light ON, Fan ON)
     */
    void execute();

    /**
     * Kaam undo karne ke liye method (e.g. Light OFF, Fan OFF)
     */
    void undo();
}

/**
 * Receiver class - Light ka real kaam yahin hota hai.
 */
class Light {
    public void on() {
        System.out.println(" Light is ON");
    }

    public void off() {
        System.out.println(" Light is OFF");
    }
}

/**
 * Receiver class - Fan ka real kaam yahin hota hai.
 */
class Fan {
    public void on() {
        System.out.println(" Fan is ON");
    }

    public void off() {
        System.out.println(" Fan is OFF");
    }
}

/**
 * Concrete Command - Light ke ON/OFF command logic.
 */
class LightCommand implements ICommand {
    private final Light light;

    /**
     * @param light - Receiver object jisko control karna hai.
     */
    public LightCommand(Light light) {
        this.light = light;
    }

    /**
     * Light ON karne ka logic.
     */
    @Override
    public void execute() {
        light.on();
    }

    /**
     * Light OFF karne ka logic.
     */
    @Override
    public void undo() {
        light.off();
    }
}

/**
 * Concrete Command - Fan ke ON/OFF command logic.
 */
class FanCommand implements ICommand {
    private final Fan fan;

    /**
     * @param fan - Receiver object jisko control karna hai.
     */
    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    /**
     * Fan ON karne ka logic.
     */
    @Override
    public void execute() {
        fan.on();
    }

    /**
     * Fan OFF karne ka logic.
     */
    @Override
    public void undo() {
        fan.off();
    }
}

/**
 * Invoker class - Remote Controller jo commands ko handle karta hai.
 * Yeh user interaction ko command pattern se connect karta hai.
 */
class RemoteController {
    private static final int numberOfButtons = 4;

    private final ICommand[] buttons;        // Har index pe ek command
    private final boolean[] pressedButton;   // Track karta hai ki ON/UNDO state me hai ya nahi

    /**
     * Constructor: Button array & state array initialize karta hai
     */
    public RemoteController() {
        buttons = new ICommand[numberOfButtons];
        pressedButton = new boolean[numberOfButtons];

        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i] = null;               // Initially koi command assigned nahi hoti
            pressedButton[i] = false;        // Sab buttons OFF state me hote hain
        }
    }

    /**
     * Kisi button index pe ek command assign karne ke liye.
     * @param index - button ka index (0-3)
     * @param command - jo command assign karni hai (e.g., LightCommand)
     */
    public void setCommand(int index, ICommand command) {
        if (index >= 0 && index < numberOfButtons) {
            buttons[index] = command;
            pressedButton[index] = false;    // Reset state to OFF
        }
    }

    /**
     * Jab user button press kare, toh yeh function execute hota hai.
     * - Pehli baar press: command execute (ON)
     * - Dobara press: undo (OFF)
     * @param index - button index jo press kiya gaya
     */
    public void setPressedButton(int index) {
        if (index >= 0 && index < numberOfButtons && buttons[index] != null) {
            if (!pressedButton[index]) {
                buttons[index].execute(); // ON karo
            } else {
                buttons[index].undo();    // OFF karo
            }

            // State toggle kar do (ON → OFF, OFF → ON)
            pressedButton[index] = !pressedButton[index];
        } else {
            // Agar koi command assign nahi hai is button pe
            System.out.println(" No command assigned at button index: " + index);
        }
    }
}

/**
 * Client Class - Main function jahan se system chalaya jata hai
 */
public class CommandPattern {
    public static void main(String[] args) {

        // Receiver objects
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        // Remote controller banaya (Invoker)
        RemoteController remote = new RemoteController();

        // Command assign kiya buttons par
        remote.setCommand(0, new LightCommand(livingRoomLight)); // Button 0: Light
        remote.setCommand(1, new FanCommand(ceilingFan));        // Button 1: Fan

        // Button 0 press (Light ON)
        remote.setPressedButton(0);

        // Button 0 press again (Light OFF)
        remote.setPressedButton(0);

        // Button 1 press (Fan ON)
        remote.setPressedButton(1);

        // Button 1 press again (Fan OFF)
        remote.setPressedButton(1);

        // Button 2 press (No command assigned)
        remote.setPressedButton(2);
    }
}
