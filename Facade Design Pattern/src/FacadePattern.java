/**
 * This class simulates the power supply unit of the computer.
 *
 * Purpose: Provides electricity to the internal components.
 * Used internally by the ComputerFacade to start the computer.
 */
class PowerSupply {
    public void providePower() {
        System.out.println("Power supply: Power provided to all components.");
    }
}

/**
 * This class simulates the cooling system.
 *
 * Purpose: Starts the fan to keep the system cool during boot and usage.
 */
class CoolingSystem {
    public void startFan() {
        System.out.println("Cooling system: Fans started.");
    }
}

/**
 * Simulates the CPU initialization process.
 *
 * Purpose: Initializes processor-level operations required to boot.
 */
class CPU {
    public void init() {
        System.out.println("CPU: Initialization complete.");
    }
}

/**
 * Simulates the hard disk spinning process.
 *
 * Purpose: Prepares hard disk to be read/written.
 */
class HardDrive {
    public void spinUp() {
        System.out.println("HardDrive: Disk is spinning up.");
    }
}

/**
 * Simulates memory self-test process during boot.
 *
 * Purpose: Ensures memory modules are working correctly before use.
 */
class Memory {
    public void selfTest() {
        System.out.println("Memory: Self-test successful.");
    }
}

/**
 * Loads the operating system.
 *
 * Purpose: Final step in booting process — OS loading.
 */
class OperatingSystem {
    public void load() {
        System.out.println("Operating System: Loaded successfully.");
    }
}

/**
 * Simulates BIOS-level startup steps.
 *
 * Purpose: Coordinates CPU and memory to run self-test before booting.
 */
class BIOS {
    public void selfTest(CPU cpu, Memory memory) {
        cpu.init();
        memory.selfTest();
        System.out.println("BIOS: Self-test complete.");
    }
}

/**
 * This is the Facade class that hides the complex startup process.
 *
 * Purpose: Acts as the entry point for clients to start the system easily
 * without needing to know about internal components.
 *
 * Real World Use Case: Similar pattern used in service layer to hide multiple internal calls.
 */
class ComputerFacade {
    private PowerSupply powerSupply;
    private CoolingSystem coolingSystem;
    private CPU cpu;
    private Memory memory;
    private BIOS bios;
    private HardDrive hardDrive;
    private OperatingSystem operatingSystem;

    // Constructor initializes all components
    public ComputerFacade() {
        this.powerSupply = new PowerSupply();
        this.coolingSystem = new CoolingSystem();
        this.cpu = new CPU();
        this.memory = new Memory();
        this.bios = new BIOS();
        this.hardDrive = new HardDrive();
        this.operatingSystem = new OperatingSystem();
    }

    /**
     * Starts the computer by calling required components in correct order.
     *
     * Step-by-step: Power → Cooling → BIOS → HardDrive → OS
     */
    public void startComputer() {
        powerSupply.providePower();
        coolingSystem.startFan();
        bios.selfTest(cpu, memory);
        hardDrive.spinUp();
        operatingSystem.load();
        System.out.println("ComputerFacade: Computer started successfully.");
    }
}

/**
 * Main client class that only knows about the Facade.
 *
 * Purpose: Keeps the client code simple and independent of internal subsystem logic.
 */
public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.startComputer();
    }
}
